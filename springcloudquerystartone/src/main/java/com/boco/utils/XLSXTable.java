package com.boco.security.basic.license.util;

import com.boco.security.basic.license.entity.PubTenantInfoEntity;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Description: 表单工具类
 * Create Date: 2021-05-28
 * Modified By：
 * Modified Date：
 * Why & What is modified：
 * Copyright (C) 2021 boco.com.cn All Right Reserved.
 *
 * @author  :qinxiaojin
 * @version 1.0
 */
public class XLSXTable {
    public void createForm(PubTenantInfoEntity pubTenantInfoEntity,File finalXlsxFile){
        OutputStream fileOut = null;
        try {
            Workbook workBook = new SXSSFWorkbook(5000);
            // sheet 对应一个工作页
            Sheet sheet = workBook.createSheet();
            //创建第一行
            Row rowHeader = sheet.createRow(0);
            /**exls头部*/
            String[] headers = new String[]{"id", "orgName", "authKey", "tenantIndex",
                    "adminUserName", "adminPwd", "secProjectName", "systemLogoName", "authStartDate",
                    "authEndDate", "maxResourceNumber", "maxUserNumber", "secretKey", "tenantStatus",
                    "remark", "reateDate"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = rowHeader.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
            //插入租户信息
            Row rowBody = sheet.createRow(1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (pubTenantInfoEntity.getId() != null){
                Cell cellId = rowBody.createCell(0);
                cellId.setCellValue(pubTenantInfoEntity.getId().toString());
            }
            if (pubTenantInfoEntity.getOrgName() != null){
                Cell orgName = rowBody.createCell(1);
                orgName.setCellValue(pubTenantInfoEntity.getOrgName().toString());
            }
            if (pubTenantInfoEntity.getAuthKey() != null){
                Cell authKey = rowBody.createCell(2);
                authKey.setCellValue(pubTenantInfoEntity.getAuthKey().toString());
            }
            if (pubTenantInfoEntity.getTenantIndex() != null){
                Cell tenantIndex = rowBody.createCell(3);
                tenantIndex.setCellValue(pubTenantInfoEntity.getTenantIndex().toString());
            }
            if (pubTenantInfoEntity.getAdminUserName() != null){
                Cell adminUserName = rowBody.createCell(4);
                adminUserName.setCellValue(pubTenantInfoEntity.getAdminUserName().toString());
            }
            if (pubTenantInfoEntity.getAdminPwd() != null){
                Cell adminPwd = rowBody.createCell(5);
                adminPwd.setCellValue(pubTenantInfoEntity.getAdminPwd().toString());
            }
            if (pubTenantInfoEntity.getSecProjectName() != null){
                Cell secProjectName = rowBody.createCell(6);
                secProjectName.setCellValue(pubTenantInfoEntity.getSecProjectName().toString());
            }
            if (pubTenantInfoEntity.getSystemLogoName() != null){
                Cell systemLogoName = rowBody.createCell(7);
                systemLogoName.setCellValue(pubTenantInfoEntity.getSystemLogoName().toString());
            }
            if (pubTenantInfoEntity.getAuthStartDate() != null){
                Cell authStartDate = rowBody.createCell(8);
                authStartDate.setCellValue(simpleDateFormat.format(pubTenantInfoEntity.getAuthStartDate()));
            }
            if (pubTenantInfoEntity.getAuthEndDate() != null){
                Cell authEndDate = rowBody.createCell(9);
                authEndDate.setCellValue(simpleDateFormat.format(pubTenantInfoEntity.getAuthEndDate()));
            }
            if (pubTenantInfoEntity.getMaxResourceNumber() != null){
                Cell maxResourceNumber = rowBody.createCell(10);
                maxResourceNumber.setCellValue(pubTenantInfoEntity.getMaxResourceNumber().toString());
            }
            if (pubTenantInfoEntity.getMaxUserNumber() != null){
                Cell maxUserNumber = rowBody.createCell(11);
                maxUserNumber.setCellValue(pubTenantInfoEntity.getMaxUserNumber().toString());
            }
            if (pubTenantInfoEntity.getSecretKey() != null){
                Cell secretKey = rowBody.createCell(12);
                secretKey.setCellValue(pubTenantInfoEntity.getSecretKey().toString());
            }
            if (pubTenantInfoEntity.getTenantStatus() != null){
                Cell tenantStatus = rowBody.createCell(13);
                tenantStatus.setCellValue(pubTenantInfoEntity.getTenantStatus().toString());
            }
            if (pubTenantInfoEntity.getRemark() != null){
                Cell remark = rowBody.createCell(14);
                remark.setCellValue(pubTenantInfoEntity.getRemark().toString());
            }
            if (pubTenantInfoEntity.getCreateDate() != null){
                Cell createDate = rowBody.createCell(15);
                createDate.setCellValue(simpleDateFormat.format(pubTenantInfoEntity.getCreateDate()).toString());
            }
            if (finalXlsxFile.exists()) {
                fileOut = new FileOutputStream(finalXlsxFile);
            } else {
                boolean flag = finalXlsxFile.createNewFile();
                System.out.println("==========flag:" + flag);
                fileOut = new FileOutputStream(finalXlsxFile);
            }
            workBook.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOut != null){
                try {
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
