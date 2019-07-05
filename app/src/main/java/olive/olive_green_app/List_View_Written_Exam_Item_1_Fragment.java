package olive.olive_green_app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("NewApi")
public class List_View_Written_Exam_Item_1_Fragment extends Fragment {

	private WebView fee_webview;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	

		View view = inflater.inflate(R.layout.written_exam_lv_item_nda_wrtiten_exam, container, false);

		fee_webview = view.findViewById(R.id.webView_fee);

		String url = getArguments().getString("Url");

		fee_webview.loadUrl(url);

		final ProgressDialog pd = new ProgressDialog(getActivity());
		pd.setMessage("Loading...");
		pd.setCanceledOnTouchOutside(false);

		fee_webview.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				pd.show();
				if(progress == 100)
					pd.dismiss();
			}
		});

		return view;
		
	}		 

}
