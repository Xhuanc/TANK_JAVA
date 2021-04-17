package Tank_online;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public  class Audio extends Thread{
	private String filename;

	public Audio(String wavefile){
		filename = wavefile;
	}

	public void run(){
		File SoundFile = new File(filename);

		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(SoundFile);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		AudioFormat Format = audioInputStream.getFormat();
		SourceDataLine sdl = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class,Format);

		try {
			sdl = (SourceDataLine)AudioSystem.getLine(info);
			sdl.open(Format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		sdl.start();
		int nBytesRead = 0;
		//缓冲
		byte[] abData = new byte [1024];
		try {
			while(nBytesRead!=-1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0) {
					sdl.write(abData, 0, nBytesRead);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sdl.drain();
			sdl.close();
		}
	}
}