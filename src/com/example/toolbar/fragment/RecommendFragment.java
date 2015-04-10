package com.example.toolbar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.toolbar.R;
import com.example.toolbar.view.CircularBannerView;
import com.example.toolbar.view.CircularBannerView.OnItemClickListener;
import com.example.toolbar.view.LazyListView;

/**
 * 推荐页面
 * 
 * @author putaoji
 * 
 */
public class RecommendFragment extends Fragment {
	private View view;
	private String imageUrl1 = "http://file.bmob.cn/M00/BC/58/wKhkA1RWKCWAFbDnAAD6kK5MVWY539.jpg";
	private String imageUrl2 = "http://file.bmob.cn/M00/BC/51/wKhkA1RWJx2AA7yJAAF2sbQHav4772.jpg";
	private String imageUrl3 = "http://file.bmob.cn/M00/2C/2C/wKhkC1RWJwiAGghyAAD8cntUUN4599.jpg";
	private String imageUrl4 = "http://file.bmob.cn/M00/2C/2B/wKhkC1RWJvOABBhbAAEqaHZTrI4036.jpg";
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_recommend, null, false);
		CircularBannerView circular_banner = (CircularBannerView) view
				.findViewById(R.id.circular_banner);
		LazyListView list_recommend = (LazyListView) view
				.findViewById(R.id.list_recommend);
		ScrollView scrollview = (ScrollView) view.findViewById(R.id.scrollview);
		circular_banner.setImageResouce(new String[] { imageUrl1, imageUrl2,
				imageUrl3, imageUrl4 }, null, new OnItemClickListener() {
					
					@Override
					public void onclick(int position) {
Toast.makeText(getActivity(), "点击了"+position, 0).show();						
					}
				});
		list_recommend
				.setAdapter(new ArrayAdapter<String>(getActivity(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1,
						new String[] { "one", "two", "three", "four", "one",
								"two", "three", "four", "one", "two", "three",
								"four", "one", "two", "three", "four", "one",
								"two", "three", "four" }));
		scrollview.smoothScrollTo(0, 20);
		return view;
	}
}
