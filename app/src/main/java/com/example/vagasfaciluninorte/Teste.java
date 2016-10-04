package com.example.vagasfaciluninorte;

import java.util.List;

import android.test.AndroidTestCase;

public class Teste extends AndroidTestCase{
	
	public void testCrud(){
		
		Estacionameto e = new Estacionameto(10, "Rua Dez de Julho");
		EstacionamentoDAO edao = EstacionamentoDAO.getinstance(getContext());
		
		edao.salvar(e);
		
		List<Estacionameto> nobanco = edao.recuperarTodos();
		assertFalse(nobanco.isEmpty());
		
		
		
	}
	
	
	

}
