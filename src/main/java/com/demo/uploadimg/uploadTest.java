//package com.demo.uploadimg;
//
//import org.aspectj.util.FileUtil;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class uploadTest {
//
//    @RequestMapping(value = "/uploda_picture", method = RequestMethod.POST)
//    public void uploda_picture(@RequestParam(value = "picture", required = false) MultipartFile[] pictures,
//                               HttpServletRequest request, ModelMap modelMap) {
//        int code = 0;
//        String desc = "操作失败!";
//        //接收前端传回来的参数
//        Map<String, Object> map = getForm("orders");
//        // 初始化用户最终图片
//        String resultPicture = null;
//        /**
//         * 遍历前台传回来的所有图片
//         */
//        List<String> pictureList = new ArrayList<String>();
//        if (pictures != null&&pictures.length>0) {
//            for (int i = 0; i < pictures.length; i++) {
//                String originalFilename = pictures[i].getOriginalFilename();
//                String contentType = pictures[i].getContentType();
//                String name = pictures[i].getName();
//                long size = pictures[i].getSize();
//                System.out.println("###OriginalFilename:"+originalFilename + "###contentType:" + contentType + "###name:" + name + "###size:" + size);
//                //循环取出list中的每一张图片
//                try {
//                    //识别图片，并且保存之后，拿到图片路径
//                    resultPicture = FileUtil.saveFile(pictures[i].getInputStream(),PropertieFileUtil.getPropertyValue("web","file.root"), "member", originalFilename);
//                    if (resultPicture!=null&&!"".equals(resultPicture)) {
//                        pictureList.add(resultPicture);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        } else {
//            code = 3;
//            desc = "未获取到图片文件";
//            modelMap.put("code", code);
//            modelMap.put("desc", desc);
//        }
//        try {
//            Map<String, Object> data = new HashMap<String, Object>();
//            data.put("cut_image", pictureList);
//            data.put("source", map.get("source"));
//            data.put(Constants.REQUEST_KEY, "uploadService.insert_picture");
//            ResponseObject responseObject=api.callApi(new RequestObject(data));
//            if (responseObject!=null) {
//                modelMap.put("data", responseObject.getItem());
//                code=1;
//                desc="操作成功";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            code = 0;
//            desc = "操作失败!";
//        }
//        modelMap.put("code", code);
//        modelMap.put("desc", desc);
//    }
//
//
//
////=====================================================================================================================================================
////
////
////    @Override
////    public List<Map<String, Object>> insert_picture(Map<String, Object> param) {
////        int source = Tools.toInt(param.get("source"));
////        List<String> cut_images = (List<String>) param.get("cut_image");
////        List<Map<String, Object>> result = new  ArrayList<Map<String, Object>>();
////        for (int i = 0; i < cut_images.size(); i++) {
////            Object desc_detail_id = uploadDao.insertDetailPicture(i+1, cut_images.get(i),source);
////            Map<String,Object> map = new HashMap<String, Object>();
////            map.put("desc_detail_id", desc_detail_id);
////            //再查询一边详情表，返回该图
////            map.put("picture",uploadDao.findPictureByDetail(desc_detail_id));
////            result.add(map);
////        }
////        return result ;
////    }
////
////=====================================================================================================================================================
////
////    @Override
////    public Object insertDetailPicture(int detail_order, String detail_content,int source) {
////        StringBuffer sql = new StringBuffer();
////        sql.append(" INSERT INTO concord_goods_desc_detail (               \n");
////        sql.append(" 	detail_order,                                      \n");
////        sql.append(" 	detail_content                                    \n");
////        sql.append(" )                                                     \n");
////        sql.append(" VALUES                                                \n");
////        sql.append(" 	(                                                  \n");
////        sql.append(" 		?, (                                           \n");
////        sql.append(" 			SELECT                                     \n");
////        sql.append(" 				CONCAT(x.app_domain, '/upload/' ,?)    \n");
////        sql.append(" 			FROM                                       \n");
////        sql.append(" 				concord_app x                          \n");
////        sql.append(" 			WHERE                                      \n");
////        sql.append(" 				x.app_source = ?                       \n");
////        sql.append(" 		)                                              \n");
////        sql.append(" 	)                                                  \n");
////        return queryHelper.insert(sql.toString(), detail_order,detail_content,source);
////    }
//}
