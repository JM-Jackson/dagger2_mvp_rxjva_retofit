package com.comagic.tabler.common.util;


import android.webkit.WebSettings;
import android.webkit.WebView;

import com.comagic.tabler.common.api.RequestClient;


public class WebViewUtil {
	
	/**
	 * 初始化webView加载数据
	 * 
	 * @param str
	 * @return
	 */
	public static String initWebView(String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<meta charset=\"utf-8\">");
		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,initial-scale=1.0,maximum-scale=1.0,user-scalable=yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />");
		buffer.append("<meta name=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />");
		buffer.append("<title>webview</title>");
		buffer.append("<base href=\"" + RequestClient.IMAGE_URL + "\" />");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<div style=\"line-height:1.5em;color:#707070;padding:0 0 10px 0\">");
		buffer.append(str);
		buffer.append("</div>");
		buffer.append("</body>");
		buffer.append("</html>");
		return buffer.toString();
	}

	public static String initWebView(String title, String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<meta charset=\"utf-8\">");
		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,initial-scale=0.5,maximum-scale=1.0,user-scalable=yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />");
		buffer.append("<meta name=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />");
		buffer.append("<title>webview</title>");
		buffer.append("<base href=\"" + RequestClient.IMAGE_URL + "\" />");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<h3 style=\"text-align:center;color:#333333;font-size:28px;\">");
		buffer.append(title);
		buffer.append("</h3>");
		buffer.append("<div style=\"line-height:1.5em;color:#707070;padding:0 0 10px 0\">");
		buffer.append(str);
		buffer.append("</div>");
		buffer.append("</body>");
		buffer.append("</html>");
		return buffer.toString();
	}

	public static String initWebView(String title, String time, String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<meta charset=\"utf-8\">");
		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,initial-scale=1.0,maximum-scale=1.0,user-scalable=yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />");
		buffer.append("<meta name=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />");
		buffer.append("<title>webview</title>");
		buffer.append("<base href=\"" + RequestClient.IMAGE_URL + "\" />");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<h7 style=\"text-align:left;display:block;margin-bottom:4px;color:#333333;font-size:16px;\">");
		buffer.append(title);
		buffer.append("</h7>");
		buffer.append("<h7 style=\"text-align:left;display:block;color:#666666;font-size:10px;\">");
		buffer.append(time);
		buffer.append("</h7>");
		buffer.append("<hr style=\"color:#707070;\"/>");
		// buffer.append("<div style=\"line-height:1.5em;color:#707070;padding:0 0 10px 0\">");
		buffer.append(str);
		// buffer.append("</div>");
		buffer.append("</body>");
		buffer.append("</html>");
		return buffer.toString();
	}

	public static String initWebView(String title, String time, String author, String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<meta charset=\"utf-8\">");
		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,initial-scale=1.0,maximum-scale=1.0,user-scalable=yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />");
		buffer.append("<meta name=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />");
		buffer.append("<title>webview</title>");
		buffer.append("<base href=\"" + RequestClient.IMAGE_URL + "\" />");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<h7 style=\"text-align:left;display:block;margin-bottom:4px;color:#333333;font-size:14px;\">");
		buffer.append(title);
		buffer.append("</h7>");
		buffer.append("<h7 style=\"text-align:left;display:block;color:#666666;font-size:10px;\">");
		buffer.append("published:" + time);
		buffer.append("&nbsp;&nbsp;&nbsp;&nbsp;");
		buffer.append("Author:" + author);
		buffer.append("</h7>");
		buffer.append("<hr style=\"color:#707070;\"/>");
		// buffer.append("<div style=\"line-height:1.5em;color:#707070;font-size:24px;padding:0 0 10px 0\">");
		buffer.append(str);
		// buffer.append("</div>");
		buffer.append("</body>");
		buffer.append("</html>");
		return buffer.toString();
	}

	public static String initWebView2(String title, String time, String author) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<meta charset=\"utf-8\">");
		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,initial-scale=1.0,maximum-scale=1.0,user-scalable=yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />");
		buffer.append("<meta name=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />");
		buffer.append("<title>webview</title>");
		buffer.append("<base href=\"" + RequestClient.IMAGE_URL + "\" />");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<h3 style=\"text-align:center;color:#333333;font-size:28px;\">");
		buffer.append(title);
		buffer.append("</h3>");
		buffer.append("<h4 style=\"text-align:center;width:100%;display:block;color:#666666;font-size:20px;\">");
		buffer.append("published:" + time);
		buffer.append("&nbsp;&nbsp;&nbsp;&nbsp;");
		buffer.append("Author:" + author);
		buffer.append("</h4>");
		buffer.append("<hr style=\"color:#707070;\"/>");

		buffer.append("</body>");
		buffer.append("</html>");
		return buffer.toString();
	}

	public static String initWebViewFor19(String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<meta charset=\"utf-8\">");
//		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,initial-scale=0.5,maximum-scale=1.0,user-scalable=false\" />");
		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,user-scalable=no\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />");
		buffer.append("<meta name=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />");
//		buffer.append("<style>img{width:100%;height:auto;margin:4px}</style>");
		buffer.append("<style>img{max-width:100% !important;height:auto;}</style>");
		buffer.append("<style>p{max-width:100% !important;height:auto;}</style>");
//		buffer.append("<style>img{max-width:100%;height:auto}</style>");
		buffer.append("<style>table{max-width:100% !important;width: auto !important;}</style>");
		buffer.append("<title>webview</title>");
		buffer.append("<base href=\"" + RequestClient.IMAGE_URL + "\" />");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<div style=\"line-height:1.5em;color:#707070;padding:0 0 10px 0\">");
		buffer.append(str);
		buffer.append("</div>");
		buffer.append("</body>");
		buffer.append("</html>");
		
		LogUtil.i("Content", buffer.toString());
		
		return buffer.toString();
	}

	/**
	 * 添加首行缩进
	 * @param str
	 * @return
     */
	public static String initWebViewFor19_SJ(String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<meta charset=\"utf-8\">");
		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,user-scalable=no\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />");
		buffer.append("<meta name=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />");
		buffer.append("<style>img{max-width:100% !important;height:auto;}</style>");
		buffer.append("<style>p{max-width:100% !important;height:auto;text-indent:2em !important;}</style>");
		buffer.append("<style>table{max-width:100% !important;width: auto !important;}</style>");
		buffer.append("<title>webview</title>");
		buffer.append("<base href=\"" + RequestClient.IMAGE_URL + "\" />");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<div style=\"line-height:1.5em;color:#707070;padding:0 0 10px 0\">");
		buffer.append(str);
		buffer.append("</div>");
		buffer.append("</body>");
		buffer.append("</html>");

		LogUtil.i("Content", buffer.toString());

		return buffer.toString();
	}

	/**
	 * 没有垂直空隙
	 * @param str
	 * @return
	 */
	public static String initWebViewFor19_ZOOM(String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<meta charset=\"utf-8\">");
		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,initial-scale=0.1,maximum-scale=5.0,user-scalable=yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />");
		buffer.append("<meta name=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />");
		buffer.append("<style>img{max-width:100%;height:auto}</style>");
		buffer.append("<style>table{width:100%;}</style>");
		buffer.append("<title>webview</title>");
		buffer.append("<base href=\"" + RequestClient.IMAGE_URL + "\" />");
		buffer.append("</head>");
		buffer.append("<body>");
		buffer.append("<div style=\"line-height:1.5em;color:#707070;padding:0 0 10px 0\">");
		buffer.append(str);
		buffer.append("</div>");
		buffer.append("</body>");
		buffer.append("</html>");
		
		LogUtil.i("Content", buffer.toString());
		
		return buffer.toString();
	}
	
	public static String initWebViewFor19New(String content) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html> ");
		buffer.append("<head> ");
		buffer.append("<style type=\"text/css\"> ");
		buffer.append("body {font-size:40px;}");
		buffer.append("</style> ");
		buffer.append("</head> ");
		buffer.append("<body>");
		buffer.append("<script type='text/javascript'>");
		buffer.append("window.onload = function(){");
		buffer.append("document.getElementsByTagName('body')[0].style.webkitTextSizeAdjust= '250%'");
		buffer.append("var $img = document.getElementsByTagName('img');");
		buffer.append("for(var p in  $img){");
		buffer.append(" $img[p].style.width = '100%';");
		buffer.append("$img[p].style.height ='auto'");
		buffer.append("}");
		buffer.append("}");
		buffer.append("</script>");
		buffer.append(content);
		buffer.append("</body>");
		buffer.append("</html>");
		return buffer.toString();
	}

	/**
	 * webview初始化
	 * @param webView
	 */
	public static void initWebViewSetting(WebView webView){

//		WebSettings webSettings = webView.getSettings();
//		webSettings.setJavaScriptEnabled(true);
//		webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
//		webSettings.setBlockNetworkImage(false);
//		webSettings.setBlockNetworkLoads(false);
////		webSettings.setLoadWithOverviewMode(true);
////		webSettings.setBuiltInZoomControls(true);
////		webSettings.setSupportZoom(true);			//设定支持缩放
////		webSettings.setUseWideViewPort(true);		//设定支持viewport
//		webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//		webSettings.setUseWideViewPort(true);
//		webSettings.setSupportZoom(true);//可以缩放
//		//webSettings.setTextZoom(10);
//		//webSettings.setTextSize(WebSettings.TextSize.SMALLEST);
//
//
//		webSettings.setBuiltInZoomControls(true);//显示放大缩小
//		webSettings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);//默认缩放模式



		WebSettings webSettings = webView.getSettings();
		webSettings.setDefaultFontSize(16);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
		webSettings.setBlockNetworkImage(false);
		webSettings.setBlockNetworkLoads(false);

		webSettings.setUseWideViewPort(true);
		webSettings.setLoadWithOverviewMode(true);

		webSettings.setDefaultTextEncodingName("UTF-8");
		webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webSettings.setBuiltInZoomControls(false); // 设置显示缩放按钮 settings.setSupportZoom(false);

		webView.setBackgroundResource(android.R.color.transparent); // 设置背景色
		webView.getBackground().setAlpha(0); // 设置填充透明度 范围：0-255

	}



	public static String initWebViewNormalFormat(String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>");
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<meta charset=\"utf-8\">");
//		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,initial-scale=0.5,maximum-scale=1.0,user-scalable=false\" />");
		buffer.append("<meta id=\"viewport\" name=\"viewport\" content=\"width=device-width,height=device-height,user-scalable=no\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />");
		buffer.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />");
		buffer.append("<meta name=\"black\" name=\"apple-mobile-web-app-status-bar-style\" />");
//		buffer.append("<style>img{width:100%;height:auto;margin:4px}</style>");
		buffer.append("<style>img{max-width:100% !important;height:auto;}</style>");
		buffer.append("<style>p{max-width:100% !important;height:auto;}</style>");
//		buffer.append("<style>img{max-width:100%;height:auto}</style>");
		buffer.append("<style>table{max-width:100% !important;width: auto !important;}</style>");
		buffer.append("<title>webview</title>");
		buffer.append("<base href=\"" + RequestClient.IMAGE_URL + "\" />");
		buffer.append("</head>");
		buffer.append("<body>");
//		buffer.append("<div style=\"line-height:1.5em;color:#707070;padding:0 0 10px 0\">");
		buffer.append(str);
//		buffer.append("</div>");
		buffer.append("</body>");
		buffer.append("</html>");

		LogUtil.i("Content", buffer.toString());

		return buffer.toString();
	}


}
