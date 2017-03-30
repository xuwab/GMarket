package com.example.wab.gmarket.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	/**
	 * 图片加载
	 */
	protected View mRootView;
	protected Intent mBundleIntent;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		if (getLayoutId() != 0) {
			mRootView = inflater.inflate(getLayoutId(), container, false);
		}
		initView(mRootView);
		setUserVisibleHint(true);
		setListener();
		initData();
		return mRootView;
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		if (hidden) {
			mBundleIntent = null;
		}
		super.onHiddenChanged(hidden);
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		// TODO Auto-generated method stub
		super.setUserVisibleHint(isVisibleToUser);
	}

	/**
	 * 此方法描述的是： 初始化所有数据的方法
	 *
	 * @author: Andruby
	 * @version: 2014-3-12 下午3:17:46
	 */
	protected abstract void initData();

	/**
	 * 此方法描述的是： 获取布局
	 *
	 * @author: Andruby
	 * @version: 2015-11-20 上午0:10:30
	 */
	protected abstract int getLayoutId();

	/**
	 * 此方法描述的是： 初始化界面
	 *
	 * @author: Andruby
	 * @version: 2015-11-20 上午0:10:30
	 */
	protected abstract void initView(View rootView);

	/**
	 * 此方法描述的是： 初始化界面
	 *
	 * @author: Andruby
	 * @version: 2015-11-20 下午13:10:30
	 */
	protected abstract void setListener();

	/**
	 * 重写ActionBar
	 *
	 * @throws
	 * @Description:
	 * @Title:initActionBar
	 * @return:void
	 * @Create: 2016年8月8日 上午10:19:24
	 * @Author : Andruby
	 */
	public void initActionBar(Activity activity) {

	}

	public void setBundleIntent(Intent intent) {
		mBundleIntent = intent;
	}

	public <T extends View> T obtainView(int resId) {
		return (T) mRootView.findViewById(resId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

	}

	/**
	 * description:摁返回时的操作
	 * class: BaseFragment
	 * author: Andruby
	 * date:2016/12/15 14:39
	 */

	public void onBackPressed() {

	}

}
