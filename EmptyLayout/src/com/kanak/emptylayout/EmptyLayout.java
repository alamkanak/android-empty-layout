package com.kanak.emptylayout;

import com.kanak.emptylayout.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class EmptyLayout {

	private Context mContext;
	private ViewGroup mLoadingView;
	private ViewGroup mEmptyView;
	private ViewGroup mErrorView;
	private Animation mLoadingAnimation;
	private ListView mListView;
	private int mErrorMessageViewId;
	private int mEmptyMessageViewId;
	private int mLoadingMessageViewId;

	// ---------------------------
	// static variables
	// ---------------------------
	/**
	 * The empty state
	 */
	public final static int TYPE_EMPTY = 1;
	/**
	 * The loading state
	 */
	public final static int TYPE_LOADING = 2;
	/**
	 * The error state
	 */
	public final static int TYPE_ERROR = 3;	

	// ---------------------------
	// default values
	// ---------------------------
	private int mEmptyType = TYPE_LOADING;
	private String mErrorMessage = "Oops! Something wrong happened";
	private String mEmptyMessage = "No items yet";
	private String mLoadingMessage = "Please wait";
	private LayoutInflater mInflater;
	private boolean mViewsAdded;
	private int mLoadingAnimationViewId;

	// ---------------------------
	// getters and setters
	// ---------------------------
	/**
	 * Gets the loading layout
	 * @return the loading layout
	 */
	public ViewGroup getLoadingView() {
		return mLoadingView;
	}
	
	/**
	 * Sets loading layout
	 * @param loadingView the layout to be shown when the list is loading
	 */
	public void setLoadingView(ViewGroup loadingView) {
		this.mLoadingView = loadingView;
	}
	
	/**
	 * Sets loading layout resource
	 * @param res the resource of the layout to be shown when the list is loading
	 */
	public void setLoadingViewRes(int res){
		this.mLoadingView = (ViewGroup) mInflater.inflate(res, null);
	}
	
	/**
	 * Gets the empty layout
	 * @return the empty layout
	 */
	public ViewGroup getEmptyView() {
		return mEmptyView;
	}
	
	/**
	 * Sets empty layout
	 * @param emptyView the layout to be shown when no items are available to load in the list
	 */
	public void setEmptyView(ViewGroup emptyView) {
		this.mEmptyView = emptyView;
	}
	
	/**
	 * Sets empty layout resource
	 * @param res the resource of the layout to be shown when no items are available to load in the list
	 */
	public void setEmptyViewRes(int res){
		this.mEmptyView = (ViewGroup) mInflater.inflate(res, null);
	}
	
	/**
	 * Gets the error layout
	 * @return the error layout
	 */
	public ViewGroup getErrorView() {
		return mErrorView;
	}
	
	/**
	 * Sets error layout
	 * @param errorView the layout to be shown when list could not be loaded due to some error
	 */
	public void setErrorView(ViewGroup errorView) {
		this.mErrorView = errorView;
	}
	
	/**
	 * Sets error layout resource
	 * @param res the resource of the layout to be shown when list could not be loaded due to some error
	 */
	public void setErrorViewRes(int res){
		this.mErrorView = (ViewGroup) mInflater.inflate(res, null);
	}
	
	/**
	 * Gets the loading animation
	 * @return the loading animation
	 */
	public Animation getLoadingAnimation() {
		return mLoadingAnimation;
	}
	
	/**
	 * Sets the loading animation
	 * @param animation the animation to play when the list is being loaded
	 */
	public void setLoadingAnimation(Animation animation) {
		this.mLoadingAnimation = animation;
	}
	
	/**
	 * Sets the resource of loading animation
	 * @param animationResource the animation resource to play when the list is being loaded
	 */
	public void setLoadingAnimationRes(int animationResource) {
		mLoadingAnimation = AnimationUtils.loadAnimation(mContext, animationResource);
	}
	
	/**
	 * Gets the list view for which this library is being used
	 * @return the list view
	 */
	public ListView getListView() {
		return mListView;
	}
	
	/**
	 * Sets the list view for which this library is being used
	 * @param listView
	 */
	public void setListView(ListView listView) {
		this.mListView = listView;
	}
	
	/**
	 * Gets the last set state of the list view
	 * @return loading or empty or error
	 */
	public int getEmptyType() {
		return mEmptyType;
	}
	
	/**
	 * Sets the state of the empty view of the list view
	 * @param emptyType loading or empty or error
	 */
	public void setEmptyType(int emptyType) {
		this.mEmptyType = emptyType;
		changeEmptyType();
	}
	
	/**
	 * Gets the message which is shown when the list could not be loaded due to some error
	 * @return the error message 
	 */
	public String getErrorMessage() {
		return mErrorMessage;
	}
	
	/**
	 * Sets the message to be shown when the list could not be loaded due to some error
	 * @param errorMessage the error message
	 * @param messageViewId the id of the text view within the error layout whose text will be changed into this message
	 */
	public void setErrorMessage(String errorMessage, int messageViewId) {
		this.mErrorMessage = errorMessage;
		this.mErrorMessageViewId = messageViewId;
	}
	
	/**
	 * Sets the message to be shown when the list could not be loaded due to some error
	 * @param errorMessage the error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.mErrorMessage = errorMessage;
	}
	
	/**
	 * Gets the message which will be shown when the list will be empty for not having any item to display
	 * @return the message which will be shown when the list will be empty for not having any item to display
	 */
	public String getEmptyMessage() {
		return mEmptyMessage;
	}
	
	/**
	 * Sets the message to be shown when the list will be empty for not having any item to display
	 * @param emptyMessage the message
	 * @param messageId the id of the text view within the empty layout whose text will be changed into this message
	 */
	public void setEmptyMessage(String emptyMessage, int messageViewId) {
		this.mEmptyMessage = emptyMessage;
		this.mEmptyMessageViewId = messageViewId;
	}
	
	/**
	 * Sets the message to be shown when the list will be empty for not having any item to display
	 * @param emptyMessage the message
	 */
	public void setEmptyMessage(String emptyMessage) {
		this.mEmptyMessage = emptyMessage;
	}
	
	/**
	 * Gets the message which will be shown when the list is being loaded
	 * @return
	 */
	public String getLoadingMessage() {
		return mLoadingMessage;
	}
	
	/**
	 * Sets the message to be shown when the list is being loaded
	 * @param loadingMessage the message
	 * @param messageViewId the id of the text view within the loading layout whose text will be changed into this message
	 */
	public void setLoadingMessage(String loadingMessage, int messageViewId) {
		this.mLoadingMessage = loadingMessage;
		this.mLoadingMessageViewId = messageViewId;
	}
	
	/**
	 * Sets the message to be shown when the list is being loaded
	 * @param loadingMessage the message
	 */
	public void setLoadingMessage(String loadingMessage) {
		this.mLoadingMessage = loadingMessage;
	}
	
	/**
	 * Gets the view in the loading layout which will be animated when the list is being loaded
	 * @return the view in the loading layout which will be animated when the list is being loaded
	 */
	public int getLoadingAnimationViewId() {
		return mLoadingAnimationViewId;
	}
	
	/**
	 * Sets the view in the loading layout which will be animated when the list is being loaded
	 * @param loadingAnimationViewId the id of the view
	 */
	public void setLoadingAnimationViewId(int loadingAnimationViewId) {
		this.mLoadingAnimationViewId = loadingAnimationViewId;
	}

	// ---------------------------
	// private methods
	// ---------------------------	
	
	private void changeEmptyType() {
		
		setDefaultValues();
		refreshMessages();

		// insert views in the root view
		if (!mViewsAdded) {
			RelativeLayout.LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
			lp.addRule(RelativeLayout.CENTER_VERTICAL);
			RelativeLayout rl = new RelativeLayout(mContext);
			rl.setLayoutParams(lp);
			if (mEmptyView!=null) rl.addView(mEmptyView);
			if (mLoadingView!=null) rl.addView(mLoadingView);
			if (mErrorView!=null) rl.addView(mErrorView);
			mViewsAdded = true;			

			ViewGroup parent = (ViewGroup) mListView.getParent();
			parent.addView(rl);
			mListView.setEmptyView(rl);
		}
		
		
		// change empty type
		if (mListView!=null) {
			View loadingAnimationView = null;
			if (mLoadingAnimationViewId > 0) loadingAnimationView = ((Activity) mContext).findViewById(mLoadingAnimationViewId); 
			switch (mEmptyType) {
			case TYPE_EMPTY:
				if (mEmptyView!=null) mEmptyView.setVisibility(View.VISIBLE);
				if (mErrorView!=null) mErrorView.setVisibility(View.GONE);
				if (mLoadingView!=null) {
					mLoadingView.setVisibility(View.GONE); 
					if (loadingAnimationView!=null && loadingAnimationView.getAnimation()!=null) loadingAnimationView.getAnimation().cancel();
				}
				break;
			case TYPE_ERROR:
				if (mEmptyView!=null) mEmptyView.setVisibility(View.GONE);
				if (mErrorView!=null) mErrorView.setVisibility(View.VISIBLE);
				if (mLoadingView!=null) {
					mLoadingView.setVisibility(View.GONE); 
					if (loadingAnimationView!=null && loadingAnimationView.getAnimation()!=null) loadingAnimationView.getAnimation().cancel();
				}
				break;
			case TYPE_LOADING:
				if (mEmptyView!=null) mEmptyView.setVisibility(View.GONE);
				if (mErrorView!=null) mErrorView.setVisibility(View.GONE);
				if (mLoadingView!=null) {
					mLoadingView.setVisibility(View.VISIBLE);
					if (mLoadingAnimation != null && loadingAnimationView!=null) {
						loadingAnimationView.startAnimation(mLoadingAnimation);
					}
					else if (loadingAnimationView!=null) {
						loadingAnimationView.startAnimation(getRotateAnimation());
					}
				}				
				break;
			default:
				break;
			}
		}
	}
	
	private void refreshMessages() {
		if (mEmptyMessageViewId>0 && mEmptyMessage!=null) ((TextView)mEmptyView.findViewById(mEmptyMessageViewId)).setText(mEmptyMessage);
		if (mLoadingMessageViewId>0 && mLoadingMessage!=null) ((TextView)mLoadingView.findViewById(mLoadingMessageViewId)).setText(mLoadingMessage);
		if (mErrorMessageViewId>0 && mErrorMessage!=null) ((TextView)mErrorView.findViewById(mErrorMessageViewId)).setText(mErrorMessage);
	}

	private void setDefaultValues() {
		if (mEmptyView==null) {
			mEmptyView = (ViewGroup) mInflater.inflate(R.layout.view_empty, null);
			if (!(mEmptyMessageViewId>0)) mEmptyMessageViewId = R.id.textViewMessage;
		}
		if (mLoadingView==null) {
			mLoadingView = (ViewGroup) mInflater.inflate(R.layout.view_loading, null);
			mLoadingAnimationViewId = R.id.imageViewLoading;
			if (!(mLoadingMessageViewId>0)) mLoadingMessageViewId = R.id.textViewMessage;
		}
		if (mErrorView==null) {
			mErrorView = (ViewGroup) mInflater.inflate(R.layout.view_error, null);
			if (!(mErrorMessageViewId>0)) mErrorMessageViewId = R.id.textViewMessage;
		}
	}
	
	private static Animation getRotateAnimation() {
		final RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
		rotateAnimation.setDuration(1500);		
		rotateAnimation.setInterpolator(new LinearInterpolator());
		rotateAnimation.setRepeatCount(Animation.INFINITE);		
		return rotateAnimation;
	}
	

	// ---------------------------
	// public methods
	// ---------------------------
	
	/**
	 * Constructor
	 * @param context the context (preferred context is any activity)
	 */
	public EmptyLayout(Context context) {
		mContext = context;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	/**
	 * Constructor
	 * @param context the context (preferred context is any activity)
	 * @param listView the list view for which this library is being used
	 */
	public EmptyLayout(Context context, ListView listView) {
		mContext = context;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mListView = listView;
	}
	
	
	/**
	 * Shows the empty layout if the list is empty
	 */
	public void showEmpty() {
		this.mEmptyType = TYPE_EMPTY;
		changeEmptyType();
	}

	/**
	 * Shows loading layout if the list is empty
	 */
	public void showLoading() {
		this.mEmptyType = TYPE_LOADING;
		changeEmptyType();
	}

	/**
	 * Shows error layout if the list is empty
	 */
	public void showError() {
		this.mEmptyType = TYPE_ERROR;
		changeEmptyType();
	}
	
	
}
