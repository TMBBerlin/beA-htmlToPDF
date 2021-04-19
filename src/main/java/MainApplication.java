import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.*;

/**
 * beA-htmlToPDF LICENSE
 * Copyright (C) 2021 TMB
 * https://bea-to-email.de
 *
 * All source code to OPEN HTML TO PDF itself is licensed under the GNU Lesser General
 * Public License (LGPL); you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 2.1 of the License, or (at your option) any later version.
 * A copy of the LGPL can be found
 * on the website of the Free Software Foundation, at
 * http://www.gnu.org/copyleft/lesser.html, and in our distributions under
 * LICENSE-LGPL-2.1.txt or LICENSE-LGPL-3.txt.
 *
 * OPEN HTML TO PDF relies on several other free or open source projects in
 * order to build and run. All currently used libraries are thought to have licenses compatible with the LGPL.
 * However, there are several jars under the obsolete-archive folder that are no longer used
 * and their licenses are out of the scope of this document. Please check the license before
 * using any of those jars.
 *
 *
 * Appendix DE für freie Lizenzen
 * von Rechtsanwalt Thomas Meier-Bading
 * "Herausgeber" meint jede Person, die dieses Programm bzw. Programmteil an andere Personen weitergibt.
 * "Verwender" meint jede Person, die dieses Programm bzw. Programmteil verwendet.
 * 1.
 * Für die Haftung des Herausgebers – gleich aus welchem Rechtsgrund – gelten folgende Regelungen:
 * Der Herausgeber haftet unbeschränkt bei eigenem Vorsatz und eigener grober Fahrlässigkeit. Bei grober Fahrlässigkeit ist die Haftung im unternehmerischen Verkehr jedoch auf den Ersatz des typischen vorhersehbaren Schadens begrenzt. Im Übrigen haftet der Herausgeber nicht.
 * Die Verjährungsfrist für Ansprüche auf Schadenersatz gegen den Herausgeber beträgt ein Jahr, gerechnet ab dem gesetzlichen Verjährungsbeginn, es sei denn, der Schaden wurde vorsätzlich herbeigeführt.
 * Die vorstehenden Haftungsbeschränkungen und -begrenzungen gelten nicht für Ansprüche nach dem Produkthaftungsgesetz sowie bei Schäden aus der Verletzung des Lebens, des Körpers oder der Gesundheit.
 * 2.
 * Ist die Haftung des Herausgebers ausgeschlossen oder eingeschränkt, so gilt das Gleiche auch für die Haftung seiner Mitarbeiter, Erfüllungs- und Verrichtungsgehilfen.
 * 3.
 * Dieser Appendix DE selbst steht unter der Lizenz CC0. Er kann, aber muss nicht zusammen mit dem Programm an Dritte weitergegeben werden.
 */
public class MainApplication {


    /**
     * Run with java -jar xxx.jar INPUT OUTPUT
     */
    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            System.out.println("Missing arguments");
            throw new IOException();
        }

        String input = args[0];
        String output = args[1];

        generatePDFFromHTML(new File(input), output);
        System.out.println("Finished");

    }


    public static void generatePDFFromHTML(File input, String outputPath) throws IOException {

        OutputStream os;
        os = new FileOutputStream(outputPath);
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode();
        builder.withFile(input);
        builder.toStream(os);
        builder.run();


    }

}
