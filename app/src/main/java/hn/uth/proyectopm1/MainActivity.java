package hn.uth.proyectopm1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button btn_Registrar,btn_InicioS;
    TextView Edit_Contra;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Edit_Contra=findViewById(R.id.Edit_Contra);
        btn_Registrar=(Button) findViewById(R.id.btn_Registrar);
        btn_InicioS=(Button) findViewById(R.id.btn_InicioS);
        ////Botones click accion
        btn_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityRegistrar.class);
                startActivity(intent);

            }
        });
        btn_InicioS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    IniciarSesion();


            }
        });

        btn_InicioS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IniciarSesion();

            }
        });

        Edit_Contra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            RestablecerContra();
            }
        });

    }

    private String getEmailFromInput() {
        EditText emailEditText = findViewById(R.id.editTextUsername);
        String email = emailEditText.getText().toString().trim();  // Elimina espacios en blanco al inicio y al final


        return email;
    }

    private String getPasswordFromInput() {
        EditText passwordEditText = findViewById(R.id.editTextPassword);
        String password = passwordEditText.getText().toString().trim();  // Elimina espacios en blanco al inicio y al final


        return password;
    }


    private void IniciarSesion() {
        String email = getEmailFromInput();
        String password = getPasswordFromInput();

        if (password.isEmpty()) {
            // El campo de contraseña está vacío
          ///  Toast.makeText(MainActivity.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Error");
            builder.setMessage("Ingrese una contraseña");
            builder.setPositiveButton("Aceptar", null);
            AlertDialog dialog = builder.create();
            dialog.show();
            return; // Salir del método sin iniciar sesión
        }
        if (email.isEmpty()) {
            // El campo de contraseña está vacío
            //Toast.makeText(MainActivity.this, "Ingrese Su Correo", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Error");
            builder.setMessage("Ingrese un Correo");
            builder.setPositiveButton("Aceptar", null);
            AlertDialog dialog = builder.create();
            dialog.show();
            return; // Salir del método sin iniciar sesión
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // El inicio de sesión fue exitoso
                            FirebaseUser user = mAuth.getCurrentUser();
                            // Realiza las acciones correspondientes, como abrir la siguiente actividad
                            Intent intent = new Intent(getApplicationContext(), ActivityHome.class);
                            startActivity(intent);
                           // Toast.makeText(MainActivity.this, "Inicio de sesión Exitosa", Toast.LENGTH_SHORT).show();

                        } else {
                            // El inicio de sesión falló
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Algo salio Mal :(");
                            builder.setMessage("Error Al Iniciar sesion");
                            builder.setPositiveButton("Aceptar", null);
                            AlertDialog dialog = builder.create();
                            dialog.show();                        }
                    }
                });
    }


    private void RestablecerContra(){
        String email = getEmailFromInput();
        mAuth.sendPasswordResetEmail(email);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Restablecer Contraseña");
        builder.setMessage("Hemos enviado un Correo para Restablecer tu Contraseña :D");
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }




}