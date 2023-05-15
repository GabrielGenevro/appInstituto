package br.edu.ifsc.chapeco.prog3.instituto.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Cadastro {

    //atributos
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String telefone;
    private String endereco;
    private String senha;
    private int tipo;

    //construtor
    public Cadastro(JSONObject jo)
    {
        try {
            this.id = jo.getInt("id");
            this.email = jo.getString("email");
            this.nome = jo.getString("nome");
            this.cpf = jo.getString("cpf");
            this.rg = jo.getString("rg");
            this.telefone = jo.getString("telefone");
            this.endereco = jo.getString("endereco");
            this.senha = jo.getString("senha");
            this.tipo = jo.getInt("cdtipo");
        }catch(JSONException je)
        {

        }
    }
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id);
            json.put("email", this.email);
            json.put("nome", this.nome);
            json.put("cpf", this.cpf);
            json.put("rg", this.rg);
            json.put("telefone", this.telefone);
            json.put("endereco", this.endereco);
            json.put("senha", this.senha);
            json.put("cdtipo", this.tipo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
    public Cadastro()
    {
        this.email = "";
        this.nome = "";
        this.cpf = "000.000.000-00";
        this.rg = "0.000.000";
        this.telefone = "+55";
        this.endereco = "";
        this.senha = "";
        this.tipo = 0;
    }

    //metodos

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome()
    {
        return this.nome;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getCpf()
    {
        return this.cpf;
    }
    public String getRg()
    {
        return this.rg;
    }
    public String getTelefone()
    {
        return this.telefone;
    }
    public String getEndereco()
    {
        return this.endereco;
    }
    public String getSenha()
    {
        return this.senha;
    }
    public int getTipo()
    {
        return this.tipo;
    }

    public boolean setNome(String nome)
    {
        boolean valido = false;
        if((nome.length() > 5))
        {
            this.nome = nome;
            valido = true;
        }
        return valido;
    }
    public boolean setEmail(String email)
    {
        boolean valido = false;
        if(email.length() > 4)
        {
            this.email = email;
            valido = true;
        } else {
            this.email = " ";
        }
        return valido;
    }
    public boolean setCpf(String cpf)
    {
        cpf = cpf.replace(".", "").replace("-", "");
        boolean valido = false;
        if ( cpf.length() == 11)
        {
            this.cpf = cpf;
            valido = true;
        }
        return valido;
    }
    public boolean setRg(String rg)
    {
        rg = rg.replace(".", "");
        boolean valido = false;
        if(rg.length() >= 7 && rg.length() <= 9)
        {
            this.rg = rg;
            valido = true;
        }
        return valido;
    }
    public boolean setTelefone(String telefone)
    {
        telefone = telefone.replace(" ", "");
        boolean valido = false;
        if( telefone.length() == 11)
        {
            this.telefone = telefone;
            valido = true;
        }
        return valido;
    }
    public boolean setEndereco(String endereco)
    {
        boolean valido = false;
        if(endereco.length() > 5)
        {
            this.endereco = endereco;
            valido = true;
        }
        return valido;
    }
    public boolean setSenha(String senha)
    {
        boolean valido = false;
        if(senha.length() > 5)
        {
            this.senha = senha;
            valido = true;
        }
        return valido;
    }
    public boolean setTipo(String tipo)
    {
        boolean valido = false;
        if(tipo.length() == 1)
        {
            this.tipo = Integer.parseInt(tipo);
            valido = true;
        }
        return valido;
    }
}

