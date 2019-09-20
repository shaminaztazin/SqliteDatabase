package com.sqlitedatabase.sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.IDN;

public class MainActivity extends AppCompatActivity {

    EditText etxtId,etxtName,etxtCell;
    Button btnSave,btnView,btnUpdate,btnDelete;
    SQLiteDb mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtId=findViewById(R.id.etext_id);
        etxtName=findViewById(R.id.etext_name);
        etxtCell=findViewById(R.id.etext_cell);

        btnSave=findViewById(R.id.btn_save);
        btnView=findViewById(R.id.btn_view);
        btnUpdate=findViewById(R.id.btn_update);
        btnDelete=findViewById(R.id.btn_delete);

        mydb=new SQLiteDb(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=etxtId.getText().toString();
                String name=etxtName.getText().toString();
                String cell=etxtCell.getText().toString();

                if(id.isEmpty())
                {
                    etxtId.requestFocus();
                    etxtId.setError("Enter Id");

                }
                else if(name.isEmpty())
                {
                    etxtName.requestFocus();
                    etxtName.setError("Error Name");
                }

                else if(cell.isEmpty()){
                    etxtCell.setError("Enter Cell");
                }
                else
                {
                    boolean check=mydb.insertData(id,name,cell);
                    if(check==true)
                    {
                        Toast.makeText(MainActivity.this,"Data Insert Successfully",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
