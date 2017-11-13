package br.inatel.dm107;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public abstract class GsonUtil {
	private static Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();

	///recebe qqr tipo de classe (class<T>) e converte pra Json (a inteligencia disso eh transparente/interna)
	public static <T> T fromToJson(String json, Class<T> classOfT) throws JsonSyntaxException {
		return gson.fromJson(json, classOfT);
	}

	public static String toJson(Object object) {
		return gson.toJson(object);
	}

}
