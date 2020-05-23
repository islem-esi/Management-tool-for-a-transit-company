package model.entity;

public interface Interface_Entity {
	/******************** les méthodes *************************/

	public abstract boolean Ajouter();
	public abstract boolean Supprimer();
	public abstract boolean Modifier(Object obj);
	public abstract boolean Rechercher();
}
