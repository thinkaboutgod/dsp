package com.dsp.demo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyProcessor implements PageProcessor {

	@Override
	public void process(Page page) {
		
		page.addTargetRequests(
				page.getHtml().links().regex("https://blog.csdn.net/"+
						"[a‐z 0‐9 ‐]+/article/details/[0‐9]{8}").all());//将当前页面里的所有链接都添加到目标页面中
		page.putField("title",page.getHtml().xpath("//*"+
				"[@id=\"mainBox\"]/main/div[1]/div[1]/h1/text()").toString());
		
	}

	@Override
	public Site getSite() {
		return Site.me().setSleepTime(100).setRetryTimes(3);
	}

	public static void main(String[] args) {
		
		Spider.create( new MyProcessor() )
		.addUrl("https://blog.csdn.net/nav/ai")
		.addPipeline(new ConsolePipeline())
		.addPipeline(new FilePipeline("D:/data"))//以文件方式保存
		.run();
		
	}
	
	
}
