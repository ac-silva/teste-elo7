package br.com.elo7.jobs;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import br.com.elo7.jobs.data.WindowBinding;
import br.com.elo7.jobs.view.Block;
import br.com.elo7.jobs.view.Menu;
import br.com.elo7.jobs.view.MenuItem;
import br.com.elo7.jobs.viewmodel.InfoBlockViewModel;

public class MainActivity extends AppCompatActivity implements Observer {

    private WindowBinding window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Body body      = new Body(getLayout(R.id.body));
        ///Footer footer  = new Footer(getLayout(R.id.footer));


        Menu menu = findViewById(R.id.menu);

        List<MenuItem> items = new ArrayList<>();
        MenuItem item2 = new MenuItem();
        item2.setTitle("Engenharia");
        items.add(item2);
        MenuItem item = new MenuItem();
        item.setTitle("Eventos");
        items.add(item);
        menu.addItems(getBaseContext(), items);
    }

    private ViewGroup getLayout(@IdRes int id){
        return findViewById(id);
    }

    @Override
    public void update(Observable observable, Object data) {
        if(observable instanceof InfoBlockViewModel){
            MainActivity jobsActivity    = (MainActivity) this.window.load().getAdapter();
            InfoBlockViewModel viewModel = (InfoBlockViewModel) observable;
            jobsActivity.setData(viewModel.getData());
        }
    }

    public void setData(List<Block> blocks){

    }

    public LayoutInflater getInflater(){
        return (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
}
