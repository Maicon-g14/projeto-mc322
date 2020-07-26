//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.constructor;

import br.unicamp.mc322.lab10.projeto.GameMode;
import br.unicamp.mc322.lab10.projeto.PlayableClasses;
import br.unicamp.mc322.lab10.projeto.exceptions.InvalidTypeException;
import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameObject;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.CpuMonster;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PresetMap extends Map {
	/* le do HD os mapas e os armazena em um vetor, cria um mapa de strings
	 * retornando o primeiro mapa e marcando a posicao atual. */
	private static final String PATH = "./src\\br\\unicamp\\mc322\\lab10\\projeto\\map\\constructor\\";		//funciona assim no windows com eclipse, parece q se for no linux precisa trocar os \\ por /
	private static final String FILENAME = "map.txt";

	public PresetMap(GameMode gameMode, PlayableClasses chosenClass, String playerName, EquipmentLoad findableEquipment) {
		/* Le do HD o arquivo de mapas com nome filename em path */
		try {
			FileInputStream fileInputStream = new FileInputStream(PATH + FILENAME);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);        //no windows usar notepad++ e salvar com encode "utf-8" (variantes geram lixo na saida)
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			setMapsConfig(bufferedReader, gameMode, findableEquipment);

			bufferedReader.readLine();

			makeMatrix(bufferedReader);

			bufferedReader.close();

			setHeroes(chosenClass, playerName);

		} catch (FileNotFoundException error) {
			System.err.println("Arquivo base do mapa nao encontrado!");
			loaded = false;

		} catch (IOException | NumberFormatException error) {
			System.err.println("Arquivo base do mapa nao pode ser carregado!");
			loaded = false;
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
			loaded = false;
		}
	}

	private void setMapsConfig(BufferedReader bufferedReader, GameMode gameMode, EquipmentLoad findableEquipment) throws IOException {
		/* Le e armazena as configuraçoes do mapa carregado */
		String line;
		String[] aux;

		this.gameMode = gameMode;

		line = bufferedReader.readLine();
		aux = line.split("=");
		mapsAmount = Integer.parseInt(aux[1]);

		line = bufferedReader.readLine();
		aux = line.split("=");
		mapsWidth = Integer.parseInt(aux[1]);

		line = bufferedReader.readLine();
		aux = line.split("=");
		mapsHeight = Integer.parseInt(aux[1]);

		monsters = new CpuMonster[mapsAmount][];        //aloca so uma dimensao do array 2d
		this.findableEquipment = findableEquipment;
	}

	private void makeMatrix(BufferedReader bufferedReader) throws IOException {
		/* Percorre os mapas carregados transformando em matrzix de objetos */
		try {
			String line = bufferedReader.readLine();

			maps = new GameObject[mapsAmount][mapsHeight][mapsWidth];
			int y = 0;

			for (int x = 0; x < mapsAmount; x++) {        //enquanto nao chega no fim do arquivo
				while (line != null && !line.isEmpty() && y < mapsHeight) {        //enquanto a linha nao for vazia
					for (int z = 0; z < mapsWidth; z++) {
						maps[x][y][z] = createObject(line.charAt(z), new Coordinate(y, z), x);        //le cada caractere da linha
					}

					line = bufferedReader.readLine();        //avan�a para proxima linha
					y++;
				}

				if (line != null && line.isEmpty()) {
					line = bufferedReader.readLine();
				}

				y = 0;
			}
		} catch (InvalidTypeException e) {
			System.err.println(e.getMessage());
		}
	}
}
