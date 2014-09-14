package com.chriswallace.fragmentactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.chriswallace.fragmentactivity.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cwallace on 9/11/14.
 */
public class NewFragment extends Fragment{

    public NewFragment() {
    }

    public void clearText() {

        final ListView myListView = (ListView) getView().findViewById(R.id.my_list_view);
        myListView.setAdapter(null);}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        final ListView myListView = (ListView) rootView.findViewById(R.id.my_list_view);
        final Button myButton = (Button) rootView.findViewById(R.id.my_button);
        String[] listChats = {};
        final ArrayList<String> textList = new ArrayList<String>(Arrays.asList(listChats));


        myListView.setAdapter(new ChatAdapter(getActivity(), R.layout.chat_layout,
                textList));

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                myButton.setText(R.string.button_text);

                EditText editText = (EditText) rootView.findViewById(R.id.text_to_add);
                String stringToAdd =  editText.getText().toString();
                if (stringToAdd.length() == 0 ) {
                    myButton.setText("ADD TEXT");
                }
                else{
                textList.add(stringToAdd);
                editText.setText("");
                myListView.setAdapter(new ChatAdapter(getActivity(), R.layout.chat_layout,
                        textList));}




            }
        });




        return rootView;
    }
}
