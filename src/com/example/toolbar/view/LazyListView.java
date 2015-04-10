package com.example.toolbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
/**
 * 可以嵌套在ScrollView中得ListView
 * @author putaoji
 *
 */
public class LazyListView extends ListView {

		public LazyListView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
		public LazyListView(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}
		public LazyListView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

			int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
					MeasureSpec.AT_MOST);
			super.onMeasure(widthMeasureSpec, expandSpec);
		}

}
