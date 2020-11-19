package com.atguigu.springcloud.alibaba.domain;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/19 16:43
 */
public class Storage {
    private Long id;

    /*
     * 产品id
     * */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

    public Storage() {
    }

    public Storage(Long id, Long productId, Integer total, Integer used, Integer residue) {
        this.id = id;
        this.productId = productId;
        this.total = total;
        this.used = used;
        this.residue = residue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }
}
