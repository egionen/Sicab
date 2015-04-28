/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "Usuarios", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"telefone1"}),
    @UniqueConstraint(columnNames = {"cpf"}),
    @UniqueConstraint(columnNames = {"matricula"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByMatricula", query = "SELECT u FROM Usuarios u WHERE u.matricula = :matricula"),
    @NamedQuery(name = "Usuarios.findByNome", query = "SELECT u FROM Usuarios u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuarios.findByCpf", query = "SELECT u FROM Usuarios u WHERE u.cpf = :cpf"),
    @NamedQuery(name = "Usuarios.findByPlano", query = "SELECT u FROM Usuarios u WHERE u.plano = :plano"),
    @NamedQuery(name = "Usuarios.findByTelefone1", query = "SELECT u FROM Usuarios u WHERE u.telefone1 = :telefone1"),
    @NamedQuery(name = "Usuarios.findByTelefone2", query = "SELECT u FROM Usuarios u WHERE u.telefone2 = :telefone2")})
public class Usuarios implements Serializable {
    public static Object ResultSet;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "matricula", nullable = false)
    private Short matricula;
    @Column(name = "nome", length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;
    @Column(name = "plano", length = 10)
    private String plano;
    @Basic(optional = false)
    @Column(name = "telefone1", nullable = false, length = 8)
    private String telefone1;
    @Column(name = "telefone2", length = 8)
    private String telefone2;
    @Lob
    @Column(name = "endere\u00e7o", length = 65535)
    private String endereço;

    public Usuarios() {
    }

    public Usuarios(Short matricula) {
        this.matricula = matricula;
    }

    public Usuarios(Short matricula, String cpf, String telefone1) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.telefone1 = telefone1;
    }

    public Short getMatricula() {
        return matricula;
    }

    public void setMatricula(Short matricula) {
        Short oldMatricula = this.matricula;
        this.matricula = matricula;
        changeSupport.firePropertyChange("matricula", oldMatricula, matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        String oldPlano = this.plano;
        this.plano = plano;
        changeSupport.firePropertyChange("plano", oldPlano, plano);
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        String oldTelefone1 = this.telefone1;
        this.telefone1 = telefone1;
        changeSupport.firePropertyChange("telefone1", oldTelefone1, telefone1);
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        String oldTelefone2 = this.telefone2;
        this.telefone2 = telefone2;
        changeSupport.firePropertyChange("telefone2", oldTelefone2, telefone2);
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        String oldEndereço = this.endereço;
        this.endereço = endereço;
        changeSupport.firePropertyChange("endere\u00e7o", oldEndereço, endereço);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controle.Usuarios[ matricula=" + matricula + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }


}
