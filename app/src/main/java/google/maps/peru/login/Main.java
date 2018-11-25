package google.maps.peru.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1,e2,e3;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        db=new DatabaseHelper(this);
        e1=(EditText) findViewById(R.id.email);
        e2=(EditText) findViewById(R.id.pass);
        e3=(EditText) findViewById(R.id.cpass);
        b1=(Button) findViewById(R.id.register);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.salir);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main.this,Login.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();

                if(s1.equals("")|| s2.equals("")|| s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Ingrese datos",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(s2.equals(s3)){
                        Boolean chkemail =db.chkemail(s1);
                        if(chkemail == true){
                            Boolean insert =db.insert(s1,s2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registro exitosamente",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Usuario ya existe",Toast.LENGTH_SHORT).show();
                        }
                    }
                Toast.makeText(getApplicationContext(),"Contraseñas no son la misma", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
