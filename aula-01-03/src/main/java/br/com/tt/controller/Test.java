package br.com.tt.controller;

import static spark.Spark.*;

public class Test {
	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello World");
	}
}
