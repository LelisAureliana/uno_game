/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

/**
 *
 * @author sergi
 */
public interface DAO {
    /**
     * Inserir DAO na base de dados
     * @param myDAO 
     */
    public void INSERT(Object myDAO);
    /**
     * Atualizar DAO na base de dados
     * @param myDAO 
     */
    public void UPDATE(Object myDAO);
    /**
     * Remover DAO da base de dados
     * @param myDAO 
     */
    public void DELETE(Object myDAO);
}
