package be.xios.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import be.xios.model.CustomButton;

public class VisitedActivity extends Activity 
{
	private List<CustomButton> listButtons;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_buttonlist);
        
        listButtons = new ArrayList<CustomButton>();
        listButtons.add(new CustomButton("Xios Hogeschool", "Visiting right now", MainMenuActivity.class, R.drawable.ic_school, "normal"));
        listButtons.add(new CustomButton("McDonalds", "Visited yesterday at 1:00pm", MainMenuActivity.class, R.drawable.ic_store, "normal"));
                
        CustomAdapter custAd = new CustomAdapter(this, this.listButtons);
        ListView lv_array = (ListView) findViewById(R.id.listViewMainMenu);
        lv_array.setAdapter(custAd);
        
        lv_array.setOnItemClickListener(new ListViewHandler());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
	}

    private class ListViewHandler implements OnItemClickListener
    {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
		{			
			if(arg1.getTag().getClass() == CustomButton.class)
			{
				CustomButton cb = (CustomButton) arg1.getTag();
				Class<?> link = cb.getLink();				

				Intent peopleIntent = new Intent(getApplicationContext(), link);
				startActivity(peopleIntent);
			}			
		}    	
    }
}
