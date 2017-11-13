package br.inatel.exercicio2.database;

import java.util.ArrayList;
import java.util.List;

import br.inatel.exercicio2.entities.Produto;




public class ProdutoDAO {
	
	private static ProdutoDAO produtos = null;
	private ArrayList<Produto> items; // trocar por acesso ao banco
	private int id = 0;
	
	public static ProdutoDAO getInstance() {
		if (produtos == null) {
			produtos = new ProdutoDAO();
		}
		return produtos;
	}
	
	public ProdutoDAO() {
		
	}
	
	public Produto getItemById(int id) {
		Produto item = null;
		for (Produto e : items) {
			if (e.getId()== id) {
				item = e;
				break;
			}
		}
		return item;
	}
	
	public Produto createItem(Produto entity) {
		entity.setId(id);
		items.add(entity);
		id ++;
		return entity;
	}
	
	public Produto updateItem (Produto entityToUpdate) {
		int index = items.indexOf(getItemById(entityToUpdate.getId()));
		items.remove(index);
		items.add(index, entityToUpdate);
		
		return entityToUpdate;
	}
	
	public List getItems() {
		return items;
	}

	public boolean delete(int id){
		Produto entity = getItemById(id);
		if (entity != null) {
			items.remove(entity);
			return true;
		} else {
			return false;
		}
	}
	
	
	

}
