package com.kartik.org;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author kmandal
 *
 */
public class SplitBigFileAndMergeSmallFileAndReadFile {
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Instant start = Instant.now();
		System.out.println("Start time " + start);
		List<String> fileNameList = null;
		String inputfile = "D:/kartik/MongoDBCredential.txt";
		// No. of lines to be split and saved in each
		double numberOfLineEachFile = 20.0;
		String outputfile = "D:/kartik/MongoDBCredential_new.txt";
		fileNameList = oneBigFileSegeratedInMultipleFile(inputfile,
				numberOfLineEachFile);
		multipleFileReadAndWriteInNewFile(fileNameList, outputfile);
		readFileWithOutforLoop(outputfile);
		Instant finish = Instant.now();
		System.out.println("End time " + finish);
		System.out.println("Execution time "
				+ Duration.between(start, finish).toMillis());

		start = Instant.now();
		System.out.println("Start time " + start);
		fileNameList = null;
		String input = "D:/kartik/logfile.txt";
		String output = "D:/kartik/mandal/logfile.txt";
		long numSplits = 10;
		fileNameList = bigFileToSplitSmallFile(input, numSplits, output);
		multipleFileReadAndWriteInNewFile(fileNameList, output);
		readFileWithOutforLoop(output);
		finish = Instant.now();
		System.out.println("End time " + finish);
		System.out.println("Execution time "
				+ Duration.between(start, finish).toMillis());
	}

	/**
	 * Using Scanner class: A simple text scanner which can parse primitive
	 * types and strings using regular expressions.A Scanner breaks its input
	 * into tokens using a delimiter pattern, which by default matches
	 * whitespace. The resulting tokens may then be converted into values of
	 * different types using the various next methods.
	 * 
	 * @param outputfile
	 * @throws FileNotFoundException
	 */
	static void readFileWithOutforLoop(String outputfile)
			throws FileNotFoundException {
		File file = new File(outputfile);
		Scanner sc = new Scanner(file);
		// we just need to use \\Z as delimiter
		sc.useDelimiter("\\Z");

		System.out.println(sc.next());
	}

	/**
	 * Read file and split into multiple files
	 * 
	 * @param fileName
	 * @param numberOfLineEachFile
	 * @return
	 */
	static List<String> oneBigFileSegeratedInMultipleFile(String fileName,
			double numberOfLineEachFile) {
		List<String> fileNameList = new ArrayList<String>();
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			int count = 0;
			while (scanner.hasNextLine()) {
				scanner.nextLine();
				count++;
			}
			// display no. of lines in the input file.
			System.out.println("Lines in the file: " + count);

			double temp = (count / numberOfLineEachFile);
			int temp1 = (int) temp;
			int nof = 0;
			if (temp1 == temp) {
				nof = temp1;
			} else {
				nof = temp1 + 1;
			}
			System.out.println("No. of files to be generated :" + nof);

			// splitting of file into multiple files
			FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream in = new DataInputStream(fstream);

			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			for (int j = 1; j <= nof; j++) {

				try {

					// create a temp file
					File temp2 = File.createTempFile("kartik-temp-file-name" + j,
							".txt");

					System.out
							.println("Temp file : " + temp2.getAbsolutePath());
					fileNameList.add(temp2.getAbsolutePath());

					FileWriter fstream1 = new FileWriter(temp2);
					BufferedWriter out = new BufferedWriter(fstream1);
					for (int i = 1; i <= numberOfLineEachFile; i++) {
						strLine = br.readLine();
						if (strLine != null) {
							out.write(strLine);
							if (i != numberOfLineEachFile) {
								out.newLine();
							}
						}
					}
					out.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return fileNameList;
	}

	/**
	 * 
	 * @param fileNameList
	 * @param outputfile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	static void multipleFileReadAndWriteInNewFile(List<String> fileNameList,
			String outputfile) throws FileNotFoundException, IOException {
		PrintWriter pw = new PrintWriter(outputfile);
		// BufferedReader object for file1.txt
		for (String string : fileNameList) {
			BufferedReader br1 = new BufferedReader(new FileReader(string));
			String line1 = br1.readLine();
			while (line1 != null) {
				if (line1 != null) {
					pw.println(line1);
					line1 = br1.readLine();
				}
			}
			pw.flush();
			// closing resources
			br1.close();
		}
		pw.close();
	}

	/**
	 * The <b>Java.io.RandomAccessFile class</b> file behaves like a large array
	 * of bytes stored in the file system. Instances of this class support both
	 * reading and writing to a random access file. <br>
	 * <b>Java BufferedOutputStream Class</b> Java BufferedOutputStream class is
	 * used for buffering an output stream. It internally uses buffer to store
	 * data. It adds more efficiency than to write data directly into a stream.
	 * So, it makes the performance fast. For adding the buffer in an
	 * OutputStream, use the BufferedOutputStream class. Let's see the syntax
	 * for adding the buffer in an OutputStream: <br>
	 * <b>OutputStream os= new BufferedOutputStream(new
	 * FileOutputStream("D:\\IO Package\\testout.txt")); </b>
	 * 
	 * @param inputFileName
	 * @param numSplits
	 *            by size wise
	 * @param outputFileName
	 */
	static List<String> bigFileToSplitSmallFile(String inputFileName,
			long numSplits, String outputFileName) {
		List<String> fileNameList = new ArrayList<String>();
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(inputFileName, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// long numSplits = 10; //from user input, extract it from args
		long sourceSize = 0;
		try {
			sourceSize = raf.length(); // file size
		} catch (IOException e) {
			e.printStackTrace();
		}
		long bytesPerSplit = sourceSize / numSplits;
		long remainingBytes = sourceSize % numSplits;

		int maxReadBufferSize = 8 * 1024; // 8KB
		for (int destIx = 1; destIx <= numSplits; destIx++) {
			BufferedOutputStream bw = null;
			try {
				fileNameList.add(outputFileName + destIx);
				bw = new BufferedOutputStream(new FileOutputStream(
						outputFileName + destIx));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if (bytesPerSplit > maxReadBufferSize) {
				long numReads = bytesPerSplit / maxReadBufferSize;
				long numRemainingRead = bytesPerSplit % maxReadBufferSize;
				for (int i = 0; i < numReads; i++) {
					try {
						readWrite(raf, bw, maxReadBufferSize);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (numRemainingRead > 0) {
					try {
						readWrite(raf, bw, numRemainingRead);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				try {
					readWrite(raf, bw, bytesPerSplit);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (remainingBytes > 0) {
			BufferedOutputStream bw = null;
			try {
				fileNameList.add(outputFileName + (numSplits + 1));
				bw = new BufferedOutputStream(new FileOutputStream(
						outputFileName + (numSplits + 1)));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				readWrite(raf, bw, remainingBytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileNameList;
	}

	static void readWrite(RandomAccessFile raf, BufferedOutputStream bw,
			long numBytes) throws IOException {
		byte[] buf = new byte[(int) numBytes];
		int val = raf.read(buf);
		if (val != -1) {
			bw.write(buf);
		}
	}

}
