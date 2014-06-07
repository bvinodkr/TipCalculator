package com.example.layoutexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText amount;
	Button tenpercent;
	Button twelvepercent;
	Button fifteenpercent;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        tenpercent = (Button)findViewById (R.id.tenpercent);
        twelvepercent = (Button)findViewById (R.id.twelvepercent);
        fifteenpercent = (Button)findViewById (R.id.fifteenpercent);
        amount = (EditText)findViewById (R.id.editText);
        setupButtonListeners ();
    }
    
    class TipButtonListener implements OnClickListener{
    	float tipPercent = 10;
    	
    	TipButtonListener (float t)
    	{
    		tipPercent = t;
    	}
    	
		@Override
		public void onClick(View v) {
			TextView tip = (TextView)findViewById (R.id.tip);
			try{
				String val = amount.getText().toString();
				float tipVal = (Float.parseFloat(val) * tipPercent )/100;
				tip.setText(String.format("%.2f", tipVal));
				}
				catch (NumberFormatException n)
				{
					tip.setText("");
					tip.setHint("Enter valid amount");
				}
		}
    	
    }
    
    private void setupButtonListeners () {
    	tenpercent.setOnClickListener(new TipButtonListener(10));
    	twelvepercent.setOnClickListener(new TipButtonListener(12));
    	fifteenpercent.setOnClickListener(new TipButtonListener(15));
    		
    	}
    
    
}
