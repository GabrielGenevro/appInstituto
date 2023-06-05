package br.edu.ifsc.chapeco.prog3.instituto.ui.aluno;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import br.edu.ifsc.chapeco.prog3.instituto.R;
import br.edu.ifsc.chapeco.prog3.instituto.model.Aluno;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cadastro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro extends Fragment implements View.OnClickListener, Response.ErrorListener,
        Response.Listener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private EditText txnome;
    private EditText txemail;
    private EditText txcpf;
    private EditText txrg;
    private EditText txtelefone;
    private EditText txendereco;
    private EditText txsenha;
    private Button btsalvar;
    private View root;

    //volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;

    public Cadastro() {
        // Required empty public constructor

    }

    public static Cadastro newInstance(String param1, String param2) {
        Cadastro fragment = new Cadastro();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.root = inflater.inflate(R.layout.fragment_cadastro, container, false);
        this.txnome = (EditText) root.findViewById(R.id.txnome);
        this.txemail = (EditText) root.findViewById(R.id.txemail);
        this.txcpf = (EditText) root.findViewById(R.id.txcpf);
        this.txrg = (EditText) root.findViewById(R.id.txrg);
        this.txtelefone = (EditText) root.findViewById(R.id.txtelefone);
        this.txendereco = (EditText) root.findViewById(R.id.txendereco);
        this.txsenha = (EditText) root.findViewById(R.id.txsenha);
        this.btsalvar = (Button) root.findViewById(R.id.btsalvar);
        this.btsalvar.setOnClickListener(this);

        //instanciando a fila de requests - caso o objeto seja o root
        this.requestQueue = Volley.newRequestQueue(root.getContext());
        //inicializando a fila de requests do SO
        this.requestQueue.start();

        return this.root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //verificando se é o botão salvar
            case R.id.btsalvar:
                //instanciando classe de negócio
                Aluno aluno = new Aluno();
                aluno.setNome(this.txnome.getText().toString());
                aluno.setEmail(this.txemail.getText().toString());
                aluno.setCpf(this.txcpf.getText().toString());
                aluno.setRg(this.txrg.getText().toString());
                aluno.setTelefone(this.txtelefone.getText().toString());
                aluno.setEndereco(this.txendereco.getText().toString());
                aluno.setSenha(this.txsenha.getText().toString());
                //
                //String json
                String json = aluno.toJsonObject().toString();
                //request para servidor REST
                jsonObjectReq = new JsonObjectRequest(Request.Method.POST,
                        "http://10.0.2.2/cadaluno.php",
                        aluno.toJsonObject(), this, this);
                requestQueue.add(jsonObjectReq);
                break;
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(root,
                "Ops! Houve um problema ao realizar o cadastro: " +
                        error.toString(),Snackbar.LENGTH_LONG);
        mensagem.show();
    }

    @Override
    public void onResponse(Object response) {
        String resposta = response.toString();
        try {
            if(resposta.equals("500")) {
                Snackbar mensagem = Snackbar.make(root,
                        "Erro! = " + resposta,
                        Snackbar.LENGTH_LONG);
                mensagem.show();
            } else {
                //sucesso
                //limpar campos da tela
                this.txnome.setText("");
                this.txemail.setText("");
                this.txcpf.setText("");
                this.txrg.setText("");
                this.txtelefone.setText("");
                this.txendereco.setText("");
                this.txsenha.setText("");
                //mensagem de sucesso
                Snackbar mensagem = Snackbar.make(root,
                        "Sucesso! = " + resposta,
                        Snackbar.LENGTH_LONG);
                mensagem.show();
            }
        } catch (Exception e) {  e.printStackTrace(); }
    }
}