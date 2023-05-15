package br.edu.ifsc.chapeco.prog3.instituto.ui.aluno;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifsc.chapeco.prog3.instituto.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cadastro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private EditText txnome;
    private EditText txemail;
    private EditText txcpf;
    private EditText txrg;
    private EditText txtelefone;
    private EditText txsenha;
    private Button btsalvar;
    private View root;

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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(false);
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
        this.txsenha = (EditText) root.findViewById(R.id.txsenha);
        this.btsalvar = (Button) root.findViewById(R.id.btsalvar);

        return root;
    }
}