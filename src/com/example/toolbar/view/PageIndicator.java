package com.example.toolbar.view;

import static android.graphics.Paint.ANTI_ALIAS_FLAG;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
/**
 * ViewPager滑动指示器
 * @author putaoji
 *
 */
public class PageIndicator extends View implements OnPageChangeListener {
	private Paint mpaint = new Paint(ANTI_ALIAS_FLAG);

	private Callback callback;

	private ViewPager mViewPager;
	private int mCurrentPage;
	private float mPositionOffset;
	private int mScrollState;
	private boolean isCircle;
	private int color = -1;

	public void setColor(int color) {
		this.color = color;
	}

	public PageIndicator(Context context) {
		super(context);
	}

	public PageIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public PageIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void isCircle(boolean isCircle) {
		this.isCircle = isCircle;

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (color != -1) {
			mpaint.setColor(color);
		} else {
			mpaint.setColor(Color.WHITE);
		}
		if (mViewPager == null) {
			return;
		}
		final int count = mViewPager.getAdapter().getCount();

		if (count == 0) {
			return;
		}
		final int paddingLeft = getPaddingLeft();
		final float pageWidth = (getWidth() - paddingLeft - getPaddingRight())
				/ (1f * count);
		final float left = paddingLeft + pageWidth
				* (mCurrentPage + mPositionOffset);
		final float right = left + pageWidth;
		final float top = getPaddingTop();
		final float bottom = getHeight() - getPaddingBottom();
		final float cx = (left + right) / 2;
		final float cy = (top + bottom) / 2;
		final float radius = (getHeight() - (getPaddingBottom() - getPaddingTop())) / 2 <= 1 ? 2
				: (getHeight() - (getPaddingBottom() - getPaddingTop())) / 2;
		if (isCircle)
			canvas.drawCircle(cx, cy, radius, mpaint);
		else {
			canvas.drawRect(left, top, right, bottom, mpaint);
		}
	}

	public void setViewPager(ViewPager viewPager) {
		if (mViewPager == viewPager) {
			return;
		}
		if (mViewPager != null) {
			// Clear us from the old pager.
			mViewPager.setOnPageChangeListener(null);
		}
		if (viewPager.getAdapter() == null) {
			throw new IllegalStateException(
					"ViewPager does not have adapter instance.");
		}
		mViewPager = viewPager;
		mCurrentPage = mViewPager.getCurrentItem();
		mViewPager.setOnPageChangeListener(this);
		if (callback != null) {
			callback.onPageChanged(mCurrentPage);
		}
		invalidate();
	}

	@Override
	public void onPageScrollStateChanged(int state) {
		mScrollState = state;

	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels2) {
		mCurrentPage = position;
		mPositionOffset = positionOffset;
		invalidate();
	}

	@Override
	public void onPageSelected(int position) {
		if (callback != null) {
			callback.onPageChanged(position);
		}
		if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
			mCurrentPage = position;
			mPositionOffset = 0;
			invalidate();
		}

	}

	public void getPosition(Callback callback) {

		this.callback = callback;
	}

	public interface Callback {
		void onPageChanged(int position);
	}

}
