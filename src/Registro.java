public class Registro {
    private int key;
    private String nome;
    private String email;
    private Registro proximo;

    public Registro(){
        this.proximo = null;
    }
    public Registro(int key, String nome, String email){
        this.key = key;
        this.nome = nome;
        this.email = email;
        this.proximo = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Registro getProximo() {
        return proximo;
    }

    public void setProximo(Registro proximo) {
        this.proximo = proximo;
    }

    public int hashCode(){
        return key % 100;
    }
}
