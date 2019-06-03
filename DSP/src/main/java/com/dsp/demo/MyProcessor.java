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

		page.addTargetRequests(page.getHtml().links().regex("http://www.jppt.com.cn/theory/queue-C1-1.html").all());
		
		int i=2;
		String content = page.getHtml().xpath("//*[@id=\"loaded\"]/div["+i+"]").get();
		
		String quetion = page.getHtml().xpath("//*[@id=\"q_"+i+"\"]/p/text()").get();
		String answer = page.getHtml().xpath("//*[@id=\"answer_"+i+"\"]/@value").get();
		String explain = page.getHtml().xpath("//*[@id=\"explain_"+i+"\"]/@data-explain").get();
		String aop=page.getHtml().xpath("//*[@id=\"p_16_"+i+"\"]/span/text()").get();
		String bop=page.getHtml().xpath("//*[@id=\"p_32_"+i+"\"]/span/text()").get();
		String cop=page.getHtml().xpath("//*[@id=\"p_64_"+i+"\"]/span/text()").get();
		String dop=page.getHtml().xpath("//*[@id=\"p_128_"+i+"\"]/span/text()").get();
		System.out.println("内容：" + content);
		System.out.println("题目：" + quetion);
		System.out.println("答案：" + answer);
		System.out.println( "解析：" + explain);
		System.out.println( "a选项：" + aop);
		System.out.println( "b选项：" + bop);
		System.out.println( "c选项：" + cop);
		System.out.println( "d选项：" + dop);
		
		
		if (content != null) { // 如果有标题和内容
//			page.putField("title", title);
			page.putField("content", content);
		} else {
			page.setSkip(true);// 跳过
		}
	}

	@Override
	public Site getSite() {
		return Site.me().setSleepTime(100).setRetryTimes(3);
	}

	public static void main(String[] args) {

		Spider.create(new MyProcessor()).addUrl("http://www.jppt.com.cn/theory/queue-C1-1.html").addPipeline(new ConsolePipeline())
				.addPipeline(new FilePipeline("D:/data"))// 以文件方式保存
				.run();

	}

}
