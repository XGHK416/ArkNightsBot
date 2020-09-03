package com.project.xghk416.util;


import gui.ava.html.parser.HtmlParser;
import gui.ava.html.parser.HtmlParserImpl;
import gui.ava.html.renderer.ImageRenderer;
import gui.ava.html.renderer.ImageRendererImpl;

public class HtmlToImageUtil {
    public static String html2Img(String htmText, String saveImageLocation){

        HtmlParser htmlParser = new HtmlParserImpl();
        htmlParser.loadHtml(htmText);
        try {
            ImageRenderer imageRenderer = new ImageRendererImpl(htmlParser);
            imageRenderer.saveImage(saveImageLocation);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("将HTML文件转换成图片异常");
        }
        return saveImageLocation;
    }

    public static void main(String[] args) {

        String saveImageLocation = System.getProperty("user.dir");
        html2Img(RollsUtil.test(),"C:\\Users\\10278\\Desktop\\save.png");
    }
}

