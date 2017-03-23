package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.Medicine;
import com.hospital.service.MedicineService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuzheng on 17/3/16.
 */

@Controller
@RequestMapping("/")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;


    @RequestMapping(value = "admin/medicine/{page}",method = RequestMethod.GET)
    @ResponseBody
    public String getMedicine(@PathVariable String page){
        int pages = Integer.parseInt(page);
        List medicines = medicineService.getAllMedicine();
        List <Medicine> submedicines = null;
        int fromINdex = (pages -1) *10;
        if(medicines.size()>=fromINdex) {
            int toIndex = pages * 10;
            if(medicines.size()>=toIndex){
                submedicines = medicines.subList(fromINdex,toIndex);
            }else{
                submedicines = medicines.subList(fromINdex, medicines.size());
            }
        }
        class templateInfo{
            Integer id;
            String medicineName;
            Float  medicinePrice;
            Integer medicineType;
            String description;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for(Medicine medicine : submedicines) {
            templateInfo tempInfo = new templateInfo();
            tempInfo.id = medicine.getId();
            tempInfo.medicineName = medicine.getMedicineName();
            tempInfo.medicinePrice = medicine.getMedicinePrice();
            tempInfo.medicineType = medicine.getMedicineType();
            tempInfo.description = medicine.getDescription();
            result.add(tempInfo);
        }
        String json = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try{
            json = objectMapper.writeValueAsString(result);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return "{\"data\":"+json+",\"pages\":"+page+"}";
    }


    /** 增加用户
    * @param medicine
    * @return
     */
    @RequestMapping(value = "admin/medicine",method = RequestMethod.POST)
    @ResponseBody
    public String saveMedicine(@RequestBody Medicine medicine){
        medicineService.saveMedicine(medicine);
        return "success!";
    }

    /**
     * 更新药品
     * @param medicine
     * @return
     */
    @RequestMapping(value = "admin/medicine",method = RequestMethod.PUT)
    @ResponseBody
    public String updateMedicine(@RequestBody Medicine medicine){
        medicineService.updateMedicine(medicine);
        return " Update success";
    }

    /**
     * 删除药品
     */
    @RequestMapping(value = "admin/medicine",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteMedicine(@RequestBody Medicine medicine) {
        Integer id = medicine.getId();
        medicineService.deleteMedicine(id);
        return "{result:true}";
    }

}
