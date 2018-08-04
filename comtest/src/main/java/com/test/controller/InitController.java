package com.test.controller;

import com.test.cacheRepository.CacheRepository;
import com.test.domain.*;
import com.test.model.*;
import com.test.service.DmBasicInfoService;
import com.test.service.DmFphyflService;
import com.test.service.DmKpzlService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;


import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class InitController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String heloo(){
        return "hello";
    }

//    @Autowired
//    private CacheRepository cacheRepository;
    @Autowired
    private DmFphyflService dmService;
    @Autowired
    private DmKpzlService dmKpzlService;
    @Autowired
    private DmBasicInfoService dmBasicInfoService;


    //获取行业分类
    @RequestMapping(value = "/api/getIndustryType", method = RequestMethod.GET)
    public String getIndustryClassification() throws JSONException {

        List<DmFPHYFL> list = dmService.queryList();
        JSONArray json = new JSONArray();
        if (!list.isEmpty()) {
            for (DmFPHYFL p : list) {
                JSONObject object = new JSONObject();
                object.put("GSDS", p.getGSDS());
                object.put("HYFLDM", p.getHYFLDM());
                object.put("HYFLID", p.getHYFLID());
                object.put("HYFLMC", p.getHYFLMC());
                json.add(object);
            }
        }
        return json.toString();
    }

//    @RequestMapping(value="/api/get",method = RequestMethod.GET)
//    public String getC(){
//        DmFPHYFL dm=new DmFPHYFL();
//        dm.setHYFLID(1);
//        dm.setGSDS(1);
//        dm.setHYFLDM("张三");
//        dm.setHYFLMC("李四");
//        cacheRepository.put("1",dm);
//        DmFPHYFL t=(DmFPHYFL)cacheRepository.get("1");
//        return t.getHYFLDM();
//    }

    @RequestMapping(value="/api/test",method = RequestMethod.GET)
    public String test(){
        String rtn_str="";
        InitBasicInfoModel model=new InitBasicInfoModel();
        model.setHYFL(1);
        model.setHYFLMC("工业");
        model.setKPZL(1);
        model.setNSRMC("张三");
        model.setNSRSBM("11111111111111");
        model.setZJBZ("0");

        JSONObject object=JSONObject.fromObject(model);
        rtn_str=object.toString();
        return rtn_str;
    }
    //获取开票类型
    @RequestMapping(value="/api/getPrintTicketType",method = RequestMethod.GET)
    public String getPrintTicketType() throws JSONException{
        List<DmKPZL> list=dmKpzlService.queryList();
        JSONArray json = new JSONArray();
        if (!list.isEmpty()) {
            for (DmKPZL p : list) {
                JSONObject object = new JSONObject();
                object.put("KPZLID", p.getKPZLID());
                object.put("KPZLMC", p.getKPZLMC());
                object.put("KPZLDM", p.getKPZLDM());
                object.put("GSDS", p.getGSDS());
                object.put("FPZLDM",p.getFPZLDM());
                object.put("HYFLDM",p.getHYFLDM());
                json.add(object);
                //json.put(object);
            }
        }
        return json.toString();
    }

    //保存初始胡开票账户信息
//    @RequestMapping(value="/api/saveBasicInformation",method = RequestMethod.POST)
//    @ResponseBody
//    public boolean saveBasicInformation(@RequestBody  JSONObject obj){
//        InitBasicInfoModel basicInfoModel=(InitBasicInfoModel) JSONObject.toBean(obj,InitBasicInfoModel.class);
//        Date dt=new Date();
//        SimpleDateFormat formaa =new SimpleDateFormat("yyyyMMdd");
//        Calendar cl=Calendar.getInstance();
//        cl.add(Calendar.MONTH,1);
//        Yd yd=new Yd();
//        yd.setYD(formaa.format(dt));
//        yd.setKSSJ(dt);
//        yd.setJSSJ(cl.getTime());
//
//        KPJ kpj=new KPJ();
//        kpj.setKPJBH("00");
//        kpj.setZJBZ(1);
//        kpj.setKPJMC("主开票机");
//        kpj.setKSRQ(dt);
//
//        KPZH kpzh=new KPZH();
//        kpzh.setNSRSBM(basicInfoModel.getNSRSBM());
//        kpzh.setNSRMC(basicInfoModel.getNSRMC());
//        kpzh.setHYFLID(basicInfoModel.getHYFL());
//        kpzh.setHYFLMC(basicInfoModel.getHYFLMC());//行业分类名称
//
//        kpzh.setZJBZ(0);
//        kpzh.setKPJID(0);
//        kpzh.setKPJBH(kpj.getKPJBH());
//        kpzh.setKPJMC(kpj.getKPJMC());
//        kpzh.setDJKPBZ(0);
//        kpzh.setYDFJSJ("00 23:59:59");
//        kpzh.setKPZLID(basicInfoModel.getKPZL());
//
//        dmBasicInfoService.save(yd);
//        dmBasicInfoService.save(kpj);
//        dmBasicInfoService.save(kpzh);
//
//        KPR kpr=new KPR();
//        List<Kprjs> kprjs=dmBasicInfoService.queryJsForList();
//        for(Kprjs js:kprjs){
//            if(js.getJSMC().indexOf("企业")>-1){
//                kpr.setKPRJS(js.getJSID());
//                break;
//            }
//        }
//        kpr.setDLM("admin");
//        kpr.setXM("企业管理员");
//        cacheRepository.put("kpr",kpr);
//        return  true;
//    }

//    //获取初始化开票人信息
//    @RequestMapping(value="/api/getInitKpr",method = RequestMethod.GET)
//    public String getInitKPR(){
//        //这个方法写的有点问题,应该存储都是一个集合
//        KPR kpr=(KPR) cacheRepository.get("kpr");
//        JSONObject obj=JSONObject.fromObject(kpr);
//        return obj.toString();
//    }

    //获取开票人角色
    @RequestMapping(value="/api/getKprJs",method = RequestMethod.GET)
    public String getKprJs() throws JSONException {
       return dmBasicInfoService.queryForJs();
    }

    //获取密保
    @RequestMapping(value="/api/getMb",method = RequestMethod.GET)
    public String getMb(){
        return dmBasicInfoService.queryForMmquestion();
    }
    //获取限额
    @RequestMapping(value = "/api/getkpxeoption",method = RequestMethod.GET)
    public String get_kpxe_option(){
        return dmBasicInfoService.queryForKpxeOptions();
    }
    //获取发票类型与限额
    @RequestMapping(value="/api/getBillingSetting",method = RequestMethod.GET)
    public String getBillingSetting(){
       List<BillingSettingModel> models= dmBasicInfoService.getBillingSetting();
       JSONArray object= JSONArray.fromObject(models);
       return object.toString();
    }

    //修改管理员信息
    @RequestMapping(value="/api/modifyAdminInit",method=RequestMethod.POST)
    public boolean ModifyAdminInitInfo(String content){
        return  true;
    }
    //添加新的开票账户到缓存里面(别忘记是跟着开票账户那个id走的,判断数量ss)
    @RequestMapping(value="/api/addKpr",method=RequestMethod.POST)
    public boolean AddKpr(String content){

        return  true;
    }


    //***********************************
    //删除期初数据
    @RequestMapping(value="/api/deleteInitialData",method = RequestMethod.POST)
    public boolean DeleteInitalData(){
        //在缓存里面删除掉操作
        return  true;
    }

    @RequestMapping(value="/api/getKpQuota",method = RequestMethod.GET)
    public String getKpQuota(){
        return  null;
    }

    @RequestMapping(value="/api/modifyKpQuota",method = RequestMethod.POST)
    public boolean FinishInit(){

        //将缓存里面的数据全部都保存到数据库里面
        //并且将缓存数据全部清除
        return  true;
    }

    //取消
    @RequestMapping(value="/api/cancleInit",method = RequestMethod.POST)
    public boolean CancaleInit(){
        //表示这个地方
        return  false;
    }


//    //保存管理员密码信息
//    @RequestMapping(value="/api/saveAdminPass",method = RequestMethod.POST)
//    @ResponseBody
//    public boolean saveAdminInfo(@RequestBody  JSONObject obj){
//        KprInfoModel model=(KprInfoModel) JSONObject.toBean(obj,KprInfoModel.class);
//        KPR kpr=(KPR)cacheRepository.get("kpr");
//        kpr.setXM(model.getName());
//        kpr.setPASSWORD(model.getPassword());
//        kpr.setMMWTID(model.getPassQuestionId());
//        kpr.setMMWTDA(model.getPassAnswer());
//        cacheRepository.clearn("kpr");
//        cacheRepository.put("kpr",kpr);
//        return  true;
//    }

//    @RequestMapping(value = "/api/addnewdrawer",method = RequestMethod.POST)
//    @ResponseBody
//    public boolean AddNewDrawer(@RequestBody JSONObject obj){
//        KprInfoModel model=(KprInfoModel) JSONObject.toBean(obj,KprInfoModel.class);
//        List<KPR> kprs= new ArrayList<KPR>();
//        KPR kpr=new KPR();
//        kpr.setXM(model.getName());
//        kpr.setDLM(model.getLoginName());
//        kpr.setPASSWORD(model.getPassword());
//        kpr.setKPRJS(model.getRoleId());
//        kprs.add(kpr);
//        KPR temp_kpr=(KPR)cacheRepository.get("kpr");
//        kprs.add(temp_kpr);
//        cacheRepository.clearn("kpr");
//        cacheRepository.put("kpr",kprs);
//        return true;
//    }

//    @RequestMapping(value = "/api/updatenewdrawer",method = RequestMethod.POST)
//    @ResponseBody
//    public boolean updateNewDrawer(@RequestBody JSONObject obj){
//        KprInfoModel model=(KprInfoModel) JSONObject.toBean(obj,KprInfoModel.class);
//        List<KPR> kprs=(ArrayList<KPR>)cacheRepository.get("kpr");
//        for(KPR kpr:kprs){
//            if(kpr.getXM()==model.getName()){
//                kpr.setDLM(model.getLoginName());
//                kpr.setXM(model.getName());
//                kpr.setKPRJS(model.getRoleId());
//                kpr.setPASSWORD(model.getPassword());
//                break;
//            }
//        }
//        cacheRepository.clearn("kpr");
//        cacheRepository.put("kpr",kprs);
//        return true;
//    }

//    //增加发票簿信息
//    @RequestMapping(value = "/api/addInIialData",method = RequestMethod.POST)
//    @ResponseBody
//    public boolean saveInvoice(@RequestBody JSONObject obj){
//        InvoiceModel model=(InvoiceModel) JSONObject.toBean(obj,InvoiceModel.class);
//        List<InvoiceModel> temp_list=(ArrayList<InvoiceModel>)cacheRepository.get("invoice");
//        boolean isNeddAdd=true;
//        for(InvoiceModel invoice:temp_list){
//            if(invoice.getStartCode()==model.getStartCode()) {
//                isNeddAdd=false;
//                continue;
//            }
//        }
//        if(isNeddAdd) temp_list.add(model);
//        cacheRepository.put("invoice",temp_list);
//        return true;
//    }


    @RequestMapping(value="/api/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody JSONObject obj){
        boolean isTrue=false;
        KPR kpr=(KPR) JSONObject.toBean(obj,KPR.class);
        isTrue=dmBasicInfoService.queryKpr(kpr);
        ReturnModel model=new ReturnModel();
        if(isTrue){
            model.setResult("登录成功");
            model.setSuccess(true);
        }
        JSONObject object=JSONObject.fromObject(model);
        return object.toString();
    }



}
