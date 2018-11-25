package google.maps.peru.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
        e1=(EditText) findViewById(R.id.editText);

        e2=(EditText) findViewById(R.id.editText2);

        b1=(Button) findViewById(R.id.button);
        btn3=(Button) findViewById(R.id.btn3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=e1.getText().toString();
                String password =e2.getText().toString();
                Boolean Chkemailpass=db.emailpassword(email, password);
                if(Chkemailpass==true) {
                    Toast.makeText(getApplicationContext(), "Logueo exitoso", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, Menu.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_SHORT).show();

                }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Login.this,Main.class);
                startActivity(i);
            }
        });
    }
}
