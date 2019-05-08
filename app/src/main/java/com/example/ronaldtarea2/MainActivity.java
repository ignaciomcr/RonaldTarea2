package com.example.ronaldtarea2;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String valor = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Verificar();
    }


    private void Verificar(){

        Button mButtonEncender = (Button) findViewById(R.id.button1);

        mButtonEncender.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               EstadoBluetooth("ENCENDER");
           }
       }
       );

        Button mButtonApagar = (Button) findViewById(R.id.button2);

        mButtonApagar.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               EstadoBluetooth("APAGAR");
           }
       }
        );
    }


    private void EstadoBluetooth(String accion){

        TextView Historial=(TextView)findViewById(R.id.textView2);
        BluetoothAdapter miAdapatador= BluetoothAdapter.getDefaultAdapter();



        if (accion.trim().equals("ENCENDER")){
            if (miAdapatador.isEnabled()){
                Toast.makeText(getApplicationContext(), "El bluetooth ya estaba encendido",Toast.LENGTH_SHORT).show();
            }else{

                try{
                    miAdapatador.enable();
                    valor = valor + "Bluetooth fue encendido/n" ;
                    Historial.setText(valor);
                    Toast.makeText(getApplicationContext(), "Bluetooth encendido exitosamente",Toast.LENGTH_SHORT).show();

                }catch(Exception ex){
                    Toast.makeText(getApplicationContext(), ex.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        }
        else{
            if (miAdapatador.isEnabled()==false){
                Toast.makeText(getApplicationContext(), "El bluetooth ya estaba detenido",Toast.LENGTH_SHORT).show();
            }else{

                try{
                    miAdapatador.disable();
                    valor = valor + "Bluetooth fue apagado/n";
                    Historial.setText(valor);
                    Toast.makeText(getApplicationContext(), "Bluetooth apagado exitosamente",Toast.LENGTH_SHORT).show();
                }catch(Exception ex){
                    Toast.makeText(getApplicationContext(), ex.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        }


    }

}
