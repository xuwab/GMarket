package com.example.wab.gmarket.base;

import android.content.Context;
import com.example.wab.gmarket.http.AsyncHttp;
import com.example.wab.gmarket.http.request.IRequest;

/**
 * @Description: 数据处理的基础接口
 * @author: Andruby
 * @date: 2016年7月15日
 */
public abstract class BaseDataSource {
	protected AsyncHttp mAsyncHttp;
	protected Context mContext;

	public BaseDataSource(Context context) {
		mAsyncHttp = AsyncHttp.instance();
		mContext = context;
	}

	public void httpPost(IRequest request, AsyncHttp.IHttpListener httpListener) {
		mAsyncHttp.post(request, httpListener);
	}
	public void httpGet(IRequest request, AsyncHttp.IHttpListener httpListener) {
		mAsyncHttp.get(request, httpListener);
	}

	public void destroy() {
		mContext = null;
//		mAsyncHttp.cancelRequest();
	}
}
