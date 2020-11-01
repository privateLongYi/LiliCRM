package com.linxi.controller;

import com.linxi.entity.*;
import com.linxi.service.*;
import com.linxi.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 14:19
 */
@Controller
@RequestMapping("clue")
@Api(value = "线索控制类", tags = "线索控制类")
public class ClueController {

    @Autowired
    private IClueService iClueService;

    @Autowired
    private ICtypeService iCtypeService;

    @Autowired
    private IArriveService iArriveService;

    @Autowired
    private IOperatingService iOperatingService;

    @Autowired
    private IRerouteService iRerouteService;

    @Autowired
    private IFollowService iFollowService;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Autowired
    private ISuccessService iSuccessService;

    @Autowired
    private IReferralService iReferralService;

    @Autowired
    private IFailService iFailService;

    @Autowired
    private IPayrecordService iPayrecordService;

    @GetMapping("getTotalByType")
    @ApiOperation(value = "根据客户类型获得有效线索总数量")
    @ResponseBody
    public DataResult getTotalByType(@ApiParam(value = "客户类型", required = true) String ctType){
        Integer clTypeId = iCtypeService.queryCtypeByCtType(ctType);
        Integer total = iClueService.getTotalByType(clTypeId);
        return new DataResult(0, "操作成功", 0, total);
    }

    @GetMapping("editClTypeIdByClId")
    @ApiOperation(value = "编辑客户状态(改为待预约)")
    @ResponseBody
    public DataResult editClTypeIdByClId(@ApiParam(value = "编号", required = true) Integer clId,
                                         @ApiParam(value = "预约编号", required = true) Integer aId){
        //根据客户状态查询编号
        Integer clTypeId = iCtypeService.queryCtypeByCtType("待预约");
        //编辑客户状态
        iClueService.editClTypeIdByClId(clId, clTypeId);
        //编辑未到店客户为失效状态
        iArriveService.editArInvalidByAId(aId);
        return new DataResult(0, "操作成功");
    }

    @GetMapping("editPrincipal")
    @ApiOperation(value = "变更负责人")
    @ResponseBody
    public DataResult editClTypeIdByClId(@ApiParam(value = "操作用户编号", required = true) Integer uId,
                                         @ApiParam(value = "客户编号", required = true) Integer cId,
                                         @ApiParam(value = "负责人编号", required = true) Integer clUId){
        //新增操作记录
        Operating operating = new Operating(cId, uId, "变更了负责人");
        iOperatingService.saveOperating(operating);

        //根据客户编号查询线索
        List<Clue> clues = iClueService.queryClByClCId(cId);

        for (Clue clue : clues){

            //新增线索
            Clue cl = new Clue(null, clue.getClCId(), clue.getClProject(), clue.getClPlaceTime(),
                    clue.getClRemark(), clue.getClEarnest(), clUId, clue.getClSource(),
                    clue.getClMessage(), clue.getClTypeId(), 0);
            iClueService.saveClue(cl);

            //改变之前的线索为无效
            iClueService.editInvalidByClId(clue.getClId());

            //查询最新的线索编号（最大的线索编号）
            Integer clId = iClueService.queryMaxClId();

            //根据线索编号查询改约
            List<Reroute> reroutes = iRerouteService.queryReByReClId(clue.getClId());
            for (Reroute reroute : reroutes){
                //新增改约记录
                Reroute re = new Reroute(clId, reroute.getReHId(), reroute.getReLastTime(),
                        reroute.getReTime(), reroute.getReCause(), reroute.getReUId());
                iRerouteService.saveReroute(re);
            }

            //根据线索编号查询跟进
            List<Follow> follows = iFollowService.queryFByFClId(clue.getClId());
            for (Follow follow : follows){
                //新增跟进记录
                Follow f = new Follow(null, clId, follow.getfTypeId(),
                        follow.getfTime(), follow.getfContent(), follow.getfUId());
                iFollowService.saveFollow(f);
            }

            //根据线索编号查询预约
            List<Appointment> appointments = iAppointmentService.queryAByAClId(clue.getClId());
            for (Appointment appointment : appointments){

                //新增预约记录
                Appointment a = new Appointment(null, clId, appointment.getaTime(),
                        appointment.getaHId(), appointment.getaTypeId(), appointment.getaStatus());
                iAppointmentService.saveAppointment(a);

                //查询最新的预约编号（最大的预约编号）
                Integer aId = iAppointmentService.queryMaxAId();

                //根据预约编号查询转诊
                List<Referral> referrals = iReferralService.queryRByRAId(appointment.getaId());
                for (Referral referral : referrals){
                    //新增转诊记录
                    Referral r = new Referral(null, aId, referral.getrFailHId(),
                            referral.getrHId(), referral.getrMessage(), referral.getrCause());
                    iReferralService.saveReferral(r);
                }

                //根据预约编号查询未到店
                List<Arrive> arrives = iArriveService.queryArByArAId(appointment.getaId());
                for (Arrive arrive : arrives){
                    //改变之前的未到店为无效
                    iArriveService.editArInvalidByArId(arrive.getArId());
                    //新增未到店
                    Arrive ar = new Arrive(null, aId, arrive.getArHId(), arrive.getArCause(),
                            arrive.getArInvalid());
                    iArriveService.saveArrive(ar);
                }

                //根据预约编号查询未成交
                List<Fail> fails = iFailService.queryFlByFlAId(appointment.getaId());
                for (Fail fail : fails){
                    //新增未成交
                    Fail fl = new Fail(null, aId, fail.getFlHId(), fail.getFlCause());
                    iFailService.saveFail(fl);
                }

                //根据预约编号查询成交
                List<Success> successes = iSuccessService.querySBySAId(appointment.getaId());
                for (Success success : successes){
                    //新增成交
                    Success s = new Success(null, aId, success.getsHId(), success.getsMessage(),
                            success.getsSum(), success.getsPaysum(), success.getsRemark(), 1);
                    iSuccessService.saveSuccess(s);
                    //查询最新的成交编号（最大的成交编号）
                    Integer sId = iSuccessService.queryMaxSId();
                    //根据成交编号查询支付
                    List<Payrecord> payrecords = iPayrecordService.queryPByPaySId(success.getsId());
                    for (Payrecord payrecord : payrecords){
                        //新增支付
                        Payrecord p = new Payrecord(null, sId, payrecord.getPaySum(),
                                payrecord.getPayTime(), payrecord.getPayTypeId());
                        iPayrecordService.savePayrecord(p);
                    }
                }
            }
        }
        return new DataResult(0, "操作成功");
    }

}
