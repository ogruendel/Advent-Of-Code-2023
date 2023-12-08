package day05;


import util.Range;
import util.RangePair;

import java.util.*;

public class Almanac {
    public static long solvePart1(List<String> input) {
        List<Long> seedIDs = getSeedsPart1(input.get(0));
        List<RangePair> seedToSoilRanges = getSeedToSoilRanges(input.get(1));
        List<RangePair> soilToFertilizerRanges = getSoilToFertilizerRanges(input.get(2));
        List<RangePair> fertilizerToWaterRanges = getFertilizerToWaterRanges(input.get(3));
        List<RangePair> waterToLightRanges = getWaterToLightRanges(input.get(4));
        List<RangePair> lightToTemperatureRanges = getLightToTemperatureRange(input.get(5));
        List<RangePair> temperatureToHumidityRanges = getTemperatureToHumidityRanges(input.get(6));
        List<RangePair> humidityToLocationRanges = getHumidityToLocationRanges(input.get(7));
        long lowestLocation = humidityToLocationRanges.getFirst().range1().lowerBound();

        for (long seedID : seedIDs) {
            Seed seed = new Seed();
            seed.setId(seedID);
            for (RangePair range : seedToSoilRanges) {
                if (isInRange(seed.getId(), range)) {
                    seed.setSoil(range.range2().lowerBound() + (seed.getId() - range.range1().lowerBound()));
                    break;
                } else {
                    seed.setSoil(seed.getId());
                }
            }
            for (RangePair range : soilToFertilizerRanges) {
                if (isInRange(seed.getSoil(), range)) {
                    seed.setFertilizer(range.range2().lowerBound() + (seed.getSoil() - range.range1().lowerBound()));
                    break;
                } else {
                    seed.setFertilizer(seed.getSoil());
                }
            }
            for (RangePair range : fertilizerToWaterRanges) {
                if (isInRange(seed.getFertilizer(), range)) {
                    seed.setWater(range.range2().lowerBound() + (seed.getFertilizer() - range.range1().lowerBound()));
                    break;
                } else {
                    seed.setWater(seed.getFertilizer());
                }
            }
            for (RangePair range : waterToLightRanges) {
                if (isInRange(seed.getWater(), range)) {
                    seed.setLight(range.range2().lowerBound() + (seed.getWater() - range.range1().lowerBound()));
                    break;
                } else {
                    seed.setLight(seed.getWater());
                }
            }
            for (RangePair range : lightToTemperatureRanges) {
                if (isInRange(seed.getLight(), range)) {
                    seed.setTemperature(range.range2().lowerBound() + (seed.getLight() - range.range1().lowerBound()));
                    break;
                } else {
                    seed.setTemperature(seed.getLight());
                }
            }
            for (RangePair range : temperatureToHumidityRanges) {
                if (isInRange(seed.getTemperature(), range)) {
                    seed.setHumidity(range.range2().lowerBound() + (seed.getTemperature() - range.range1().lowerBound()));
                    break;
                } else {
                    seed.setHumidity(seed.getTemperature());
                }
            }
            for (RangePair range : humidityToLocationRanges) {
                if (isInRange(seed.getHumidity(), range)) {
                    seed.setLocation(range.range2().lowerBound() + (seed.getHumidity() - range.range1().lowerBound()));
                    break;
                } else {
                    seed.setLocation(seed.getHumidity());
                }
            }
            if (seed.getLocation() < lowestLocation) {
                lowestLocation = seed.getLocation();
            }
        }
        return lowestLocation;
    }

    private static List<Long> getSeedsPart1(String input) {
        input = input.substring(input.indexOf(':') + 1).strip();
        List<String> valuesString = List.of(input.split("\\s"));
        List<Long> values = new ArrayList<>();

        for (String value : valuesString) {
            values.add(Long.parseLong(value));
        }

        return values;
    }

    public static long solvePart2(List<String> input) {
        // 1016546293 too high
        List<Range> seedIDs = getSeedsPart2(input.get(0));
        List<RangePair> seedToSoilRanges = getSeedToSoilRanges(input.get(1));
        List<RangePair> soilToFertilizerRanges = getSoilToFertilizerRanges(input.get(2));
        List<RangePair> fertilizerToWaterRanges = getFertilizerToWaterRanges(input.get(3));
        List<RangePair> waterToLightRanges = getWaterToLightRanges(input.get(4));
        List<RangePair> lightToTemperatureRanges = getLightToTemperatureRange(input.get(5));
        List<RangePair> temperatureToHumidityRanges = getTemperatureToHumidityRanges(input.get(6));
        List<RangePair> humidityToLocationRanges = getHumidityToLocationRanges(input.get(7));
        long lowestLocation = humidityToLocationRanges.getFirst().range1().lowerBound();

        for (Range seedIdStart : seedIDs) {
            for (long seedID = seedIdStart.lowerBound(); seedID < seedIdStart.upperBound(); seedID++) {
                Seed seed = new Seed();
                seed.setId(seedID);
                for (RangePair range : seedToSoilRanges) {
                    if (isInRange(seed.getId(), range)) {
                        seed.setSoil(range.range2().lowerBound() + (seed.getId() - range.range1().lowerBound()));
                        break;
                    } else {
                        seed.setSoil(seed.getId());
                    }
                }
                for (RangePair range : soilToFertilizerRanges) {
                    if (isInRange(seed.getSoil(), range)) {
                        seed.setFertilizer(range.range2().lowerBound() + (seed.getSoil() - range.range1().lowerBound()));
                        break;
                    } else {
                        seed.setFertilizer(seed.getSoil());
                    }
                }
                for (RangePair range : fertilizerToWaterRanges) {
                    if (isInRange(seed.getFertilizer(), range)) {
                        seed.setWater(range.range2().lowerBound() + (seed.getFertilizer() - range.range1().lowerBound()));
                        break;
                    } else {
                        seed.setWater(seed.getFertilizer());
                    }
                }
                for (RangePair range : waterToLightRanges) {
                    if (isInRange(seed.getWater(), range)) {
                        seed.setLight(range.range2().lowerBound() + (seed.getWater() - range.range1().lowerBound()));
                        break;
                    } else {
                        seed.setLight(seed.getWater());
                    }
                }
                for (RangePair range : lightToTemperatureRanges) {
                    if (isInRange(seed.getLight(), range)) {
                        seed.setTemperature(range.range2().lowerBound() + (seed.getLight() - range.range1().lowerBound()));
                        break;
                    } else {
                        seed.setTemperature(seed.getLight());
                    }
                }
                for (RangePair range : temperatureToHumidityRanges) {
                    if (isInRange(seed.getTemperature(), range)) {
                        seed.setHumidity(range.range2().lowerBound() + (seed.getTemperature() - range.range1().lowerBound()));
                        break;
                    } else {
                        seed.setHumidity(seed.getTemperature());
                    }
                }
                for (RangePair range : humidityToLocationRanges) {
                    if (isInRange(seed.getHumidity(), range)) {
                        seed.setLocation(range.range2().lowerBound() + (seed.getHumidity() - range.range1().lowerBound()));
                        break;
                    } else {
                        seed.setLocation(seed.getHumidity());
                    }
                }

                if (seed.getLocation() < lowestLocation) {
                    lowestLocation = seed.getLocation();
                }
            }
        }
        return lowestLocation;
    }

    private static List<Range> getSeedsPart2(String input) {
        input = input.substring(input.indexOf(':') + 1).strip();
        List<String> valuesString = List.of(input.split("\\s"));
        List<Range> ranges = new ArrayList<>();

        for (int i = 0; i < valuesString.size() - 1; i += 2) {
            ranges.add(new Range(Long.parseLong(valuesString.get(i)), Long.parseLong(valuesString.get(i)) + Long.parseLong(valuesString.get(i + 1))));
        }

        return ranges;
    }

    private static boolean isInRange(long id, RangePair range) {
        return id <= range.range1().upperBound() && id >= range.range1().lowerBound();
    }

    private static List<RangePair> getGenericRanges(String input) {
        input = input.substring(input.indexOf(':') + 1).strip();
        List<String> valuesString = List.of(input.split("\\s"));
        List<Long> values = new ArrayList<>();
        List<RangePair> ranges = new ArrayList<>();

        for (String value : valuesString) {
            values.add(Long.parseLong(value));
        }

        for (int i = 0; i < values.size(); i += 3) {
            long destinationStart = values.get(i);
            long sourceStart = values.get(i + 1);
            long length = values.get(i + 2);

            ranges.add(new RangePair(new Range(sourceStart, sourceStart + length), new Range(destinationStart, destinationStart + length)));
        }

        return ranges;
    }

    private static List<RangePair> getSeedToSoilRanges(String input) {
        return getGenericRanges(input);
    }

    private static List<RangePair> getSoilToFertilizerRanges(String input) {
        return getGenericRanges(input);
    }

    private static List<RangePair> getFertilizerToWaterRanges(String input) {
        return getGenericRanges(input);
    }

    private static List<RangePair> getWaterToLightRanges(String input) {
        return getGenericRanges(input);
    }

    private static List<RangePair> getLightToTemperatureRange(String input) {
        return getGenericRanges(input);
    }

    private static List<RangePair> getTemperatureToHumidityRanges(String input) {
        return getGenericRanges(input);
    }

    private static List<RangePair> getHumidityToLocationRanges(String input) {
        return getGenericRanges(input);
    }
}