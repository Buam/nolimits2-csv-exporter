# CSV exporter for Nolimits 2 STANDARD

A simple program to extract the spline of
a coaster into a CSV-file like it is
possible with the professional license of Nolimits 2.

This can be especially useful for custom track and is achieved by extracting the spline out of the model file of a light-pattern-creator export (a Lightwave-object file).

This is the equivalent of using "Export track spline" with Nolimits 2 professional, however, the spline will not be identical as you cannot choose the spacing of the vertices with this solution (TODO).

## How to use

1. [Download](https://github.com/Buam/nolimits2-csv-exporter/releases/download/1.1/NLCSV.jar) the latest release.

2. Open the coaster you want to export in Nolimits 2 and go to Advanced>Light Pattern Creator.

3. Input a file prefix, tick "Generate SCO", as well as "T", "B", "L" and "R" at the bottom and make sure that the X and Y Offset are both 0.

4. Hit "Generate" and choose an output folder.

5. Open the program (You must have Java installed. If you haven't, download it [here](https://www.java.com/en/download/)).

6. Open the .lwo file in the previously selected output folder as the Light Pattern Creator File of the program.

7. Choose an output path for your CSV file.

8. Press "Convert" and a CSV file will be generated that can be used in Programs such as Blender (with the right importer; you can find one [here](https://github.com/geforcefan/BlenderNoLimitsCSVImporter)).
