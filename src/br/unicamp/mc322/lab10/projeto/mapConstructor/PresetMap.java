//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapConstructor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.GameMode;
import br.unicamp.mc322.lab10.projeto.QuestBase;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;

public class PresetMap extends MapLoad{
	/* le do HD os mapas e os armazena em um vetor, cria um mapa de strings
	 * retornando o primeiro mapa e marcando a posicao atual. */
	private static final String path = "./src\\\\br\\\\unicamp\\\\mc322\\\\lab10\\\\projeto\\\\mapConstructor\\\\";
	private static final String fileName = "map.txt";
	
	public PresetMap(GameMode gameMode) {
		/* Le do HD o arquivo de mapas com nome filename em path */	
		try {
			FileInputStream fileInputStream = new FileInputStream(path+fileName);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);		//no windows usar notepad++ e salvar com encode "utf-8" (variantes geram lixo na saida)
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);		
			
			setMapsConfig(bufferedReader,gameMode);
			
			bufferedReader.readLine();
			
			makeMatrix(bufferedReader);
			
			bufferedReader.close();
		
		} catch (FileNotFoundException error) {
			System.out.println("Arquivo base do mapa nao encontrado!");
			
		} catch (IOException | NumberFormatException error) {
			System.out.println("Arquivo base do mapa nao pode ser carregado!");
		}
	}
	
	private void setMapsConfig(BufferedReader bufferedReader, GameMode gameMode) throws IOException {
		/* Le e armazena as configurações do mapa carregado */
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
	}
	
	private void makeMatrix(BufferedReader bufferedReader) throws IOException {
		/* Percorre os mapas carregados transformando em matrzix de objetos */
		String line = bufferedReader.readLine();
		
		maps = new GameObject[mapsAmount][mapsHeight][mapsWidth];
		int y = 0;
		
		for (int x = 0; x < mapsAmount; x++) {		//enquanto nao chega no fim do arquivo
			
			while(line != null && !line.isEmpty() && y < mapsHeight) {		//enquanto a linha nao for vazia
			
				for (int z = 0; z < mapsWidth; z++)
					maps[x][y][z] = createObject(line.charAt(z), new Coordinate(y,z));		//le cada caractere da linha
					
				line = bufferedReader.readLine();		//avança para proxima linha
				y++;
			
			}
			
			if(line != null && line.isEmpty())
				line = bufferedReader.readLine();
			
			y=0;
		}

	}
	
}
