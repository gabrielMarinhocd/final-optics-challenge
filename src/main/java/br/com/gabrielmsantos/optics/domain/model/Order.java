package br.com.gabrielmsantos.optics.domain.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int status;

    private Date dtOrder;

    private String dtDelivery;

    private String timeOrder;

    private int lens;

    private double valueLens;

    private String materialLens;

    private String typeLens;

    private int frame;

    private double valueFrame;

    private String materialFrame;

    private String typeFrame;

    private String esfLongOe;

    private String esfCloseOd;

    private String esfCloseOe;

    private String cilLongOd;

    private String cilLongOe;

    private String cilCloseOd;

    private String cilCloseOe;

    private String eixoLongOd;

    private String eixoLongOe;

    private String eixoCloseOd;

    private String eixoCloseOe;

    private String dnpLongOd;

    private String dnpLongOe;

    private String dnpCloseOd;

    private String dnpCloseOe;

    private String heigthLongOd;

    private String heigthLongOe;

    private String heigthCloseOd;

    private String heigthCloseOe;

    private String dm;

    private String adicao;

    private String vert;

    private String hor;

    private String ponte;

    private String obs;

    private String markaLens;

    private String markaFrame;

    private String indication;

    private double valueIndication;

    private double totalLens;

    private double totalFrame;

    private String indicationStore;

    private double valueStore;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "custumer_id", referencedColumnName = "id")
    private Custumer custumer;

    @OneToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @OneToOne
    @JoinColumn(name = "status_order_id", referencedColumnName = "id")
    private StatusOrder statusOrder;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PaymentMethods> PaymentMethods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDtOrder() {
        return dtOrder;
    }

    public void setDtOrder(Date dtOrder) {
        this.dtOrder = dtOrder;
    }

    public String getDtDelivery() {
        return dtDelivery;
    }

    public void setDtDelivery(String dtDelivery) {
        this.dtDelivery = dtDelivery;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public int getLens() {
        return lens;
    }

    public void setLens(int lens) {
        this.lens = lens;
    }

    public double getValueLens() {
        return valueLens;
    }

    public void setValueLens(double valueLens) {
        this.valueLens = valueLens;
    }

    public String getMaterialLens() {
        return materialLens;
    }

    public void setMaterialLens(String materialLens) {
        this.materialLens = materialLens;
    }

    public String getTypeLens() {
        return typeLens;
    }

    public void setTypeLens(String typeLens) {
        this.typeLens = typeLens;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public double getValueFrame() {
        return valueFrame;
    }

    public void setValueFrame(double valueFrame) {
        this.valueFrame = valueFrame;
    }

    public String getMaterialFrame() {
        return materialFrame;
    }

    public void setMaterialFrame(String materialFrame) {
        this.materialFrame = materialFrame;
    }

    public String getTypeFrame() {
        return typeFrame;
    }

    public void setTypeFrame(String typeFrame) {
        this.typeFrame = typeFrame;
    }

    public String getEsfLongOe() {
        return esfLongOe;
    }

    public void setEsfLongOe(String esfLongOe) {
        this.esfLongOe = esfLongOe;
    }

    public String getEsfCloseOd() {
        return esfCloseOd;
    }

    public void setEsfCloseOd(String esfCloseOd) {
        this.esfCloseOd = esfCloseOd;
    }

    public String getEsfCloseOe() {
        return esfCloseOe;
    }

    public void setEsfCloseOe(String esfCloseOe) {
        this.esfCloseOe = esfCloseOe;
    }

    public String getCilLongOd() {
        return cilLongOd;
    }

    public void setCilLongOd(String cilLongOd) {
        this.cilLongOd = cilLongOd;
    }

    public String getCilLongOe() {
        return cilLongOe;
    }

    public void setCilLongOe(String cilLongOe) {
        this.cilLongOe = cilLongOe;
    }

    public String getCilCloseOd() {
        return cilCloseOd;
    }

    public void setCilCloseOd(String cilCloseOd) {
        this.cilCloseOd = cilCloseOd;
    }

    public String getCilCloseOe() {
        return cilCloseOe;
    }

    public void setCilCloseOe(String cilCloseOe) {
        this.cilCloseOe = cilCloseOe;
    }

    public String getEixoLongOd() {
        return eixoLongOd;
    }

    public void setEixoLongOd(String eixoLongOd) {
        this.eixoLongOd = eixoLongOd;
    }

    public String getEixoLongOe() {
        return eixoLongOe;
    }

    public void setEixoLongOe(String eixoLongOe) {
        this.eixoLongOe = eixoLongOe;
    }

    public String getEixoCloseOd() {
        return eixoCloseOd;
    }

    public void setEixoCloseOd(String eixoCloseOd) {
        this.eixoCloseOd = eixoCloseOd;
    }

    public String getEixoCloseOe() {
        return eixoCloseOe;
    }

    public void setEixoCloseOe(String eixoCloseOe) {
        this.eixoCloseOe = eixoCloseOe;
    }

    public String getDnpLongOd() {
        return dnpLongOd;
    }

    public void setDnpLongOd(String dnpLongOd) {
        this.dnpLongOd = dnpLongOd;
    }

    public String getDnpLongOe() {
        return dnpLongOe;
    }

    public void setDnpLongOe(String dnpLongOe) {
        this.dnpLongOe = dnpLongOe;
    }

    public String getDnpCloseOd() {
        return dnpCloseOd;
    }

    public void setDnpCloseOd(String dnpCloseOd) {
        this.dnpCloseOd = dnpCloseOd;
    }

    public String getDnpCloseOe() {
        return dnpCloseOe;
    }

    public void setDnpCloseOe(String dnpCloseOe) {
        this.dnpCloseOe = dnpCloseOe;
    }

    public String getHeigthLongOd() {
        return heigthLongOd;
    }

    public void setHeigthLongOd(String heigthLongOd) {
        this.heigthLongOd = heigthLongOd;
    }

    public String getHeigthLongOe() {
        return heigthLongOe;
    }

    public void setHeigthLongOe(String heigthLongOe) {
        this.heigthLongOe = heigthLongOe;
    }

    public String getHeigthCloseOd() {
        return heigthCloseOd;
    }

    public void setHeigthCloseOd(String heigthCloseOd) {
        this.heigthCloseOd = heigthCloseOd;
    }

    public String getHeigthCloseOe() {
        return heigthCloseOe;
    }

    public void setHeigthCloseOe(String heigthCloseOe) {
        this.heigthCloseOe = heigthCloseOe;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getAdicao() {
        return adicao;
    }

    public void setAdicao(String adicao) {
        this.adicao = adicao;
    }

    public String getVert() {
        return vert;
    }

    public void setVert(String vert) {
        this.vert = vert;
    }

    public String getHor() {
        return hor;
    }

    public void setHor(String hor) {
        this.hor = hor;
    }

    public String getPonte() {
        return ponte;
    }

    public void setPonte(String ponte) {
        this.ponte = ponte;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getMarkaLens() {
        return markaLens;
    }

    public void setMarkaLens(String markaLens) {
        this.markaLens = markaLens;
    }

    public String getMarkaFrame() {
        return markaFrame;
    }

    public void setMarkaFrame(String markaFrame) {
        this.markaFrame = markaFrame;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public double getValueIndication() {
        return valueIndication;
    }

    public void setValueIndication(double valueIndication) {
        this.valueIndication = valueIndication;
    }

    public double getTotalLens() {
        return totalLens;
    }

    public void setTotalLens(double totalLens) {
        this.totalLens = totalLens;
    }

    public double getTotalFrame() {
        return totalFrame;
    }

    public void setTotalFrame(double totalFrame) {
        this.totalFrame = totalFrame;
    }

    public String getIndicationStore() {
        return indicationStore;
    }

    public void setIndicationStore(String indicationStore) {
        this.indicationStore = indicationStore;
    }

    public double getValueStore() {
        return valueStore;
    }

    public void setValueStore(double valueStore) {
        this.valueStore = valueStore;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Custumer getCustumer() {
        return custumer;
    }

    public void setCustumer(Custumer custumer) {
        this.custumer = custumer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public List<br.com.gabrielmsantos.optics.domain.model.PaymentMethods> getPaymentMethods() {
        return PaymentMethods;
    }

    public void setPaymentMethods(List<br.com.gabrielmsantos.optics.domain.model.PaymentMethods> paymentMethods) {
        PaymentMethods = paymentMethods;
    }
}
