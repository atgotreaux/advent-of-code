package com.gotreaux.aoc.puzzles.year2019.day8;

import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.DigitMatrixProvider;
import java.util.List;
import java.util.stream.IntStream;

record Image(List<Matrix<Integer>> layers, int width, int height) {

    static Image of(String input, int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        if (input.length() < width * height) {
            throw new IllegalArgumentException(
                    "Input length must be at least %d".formatted(width * height));
        }

        var layers =
                IntStream.iterate(0, i -> i < input.length(), i -> i + width * height)
                        .mapToObj(
                                i -> {
                                    var layerInput =
                                            IntStream.iterate(
                                                            0,
                                                            j -> j < width * height,
                                                            j -> j + width)
                                                    .mapToObj(
                                                            j ->
                                                                    input.substring(
                                                                            i + j, i + j + width))
                                                    .toList();
                                    return new Matrix<>(layerInput, new DigitMatrixProvider());
                                })
                        .toList();

        return new Image(layers, width, height);
    }

    String render() {
        var renderBuilder = new StringBuilder((width + 1) * height);

        for (var row = 0; row < height; row++) {
            for (var col = 0; col < width; col++) {
                var cell = new Cell(row, col);
                var renderPixel =
                        layers.stream()
                                .map(layer -> EnumUtils.of(Pixel.class, layer.get(cell)))
                                .filter(pixel -> pixel != Pixel.TRANSPARENT)
                                .findFirst()
                                .orElse(Pixel.TRANSPARENT);
                renderBuilder.append(renderPixel.getLabel());
            }
            renderBuilder.append("\n");
        }

        return renderBuilder.toString();
    }
}
