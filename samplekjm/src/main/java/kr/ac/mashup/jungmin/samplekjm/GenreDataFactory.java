package kr.ac.mashup.jungmin.samplekjm;

import java.util.Arrays;
import java.util.List;

import kr.ac.mashup.jungmin.samplekjm.model.ChildData;
import kr.ac.mashup.jungmin.samplekjm.model.ParentData;

public class GenreDataFactory {

  public static List<MultiCheckGenre> makeMultiCheckGenres() {
    return Arrays.asList(makeMultiCheckRockGenre());
  }

  public static List<ParentData> makeParentData() {
    return Arrays.asList(makeParentRockData());
  }

  public static ParentData makeParentRockData() {
    return new ParentData("Rock", makeRockArtists());
  }

  public static MultiCheckGenre makeMultiCheckRockGenre() {
    return new MultiCheckGenre("Rock", makeRockArtists(), R.drawable.ic_electric_guitar);
  }

  public static List<ChildData> makeRockArtists() {
    ChildData queen = new ChildData("Queen", 8000);
    ChildData styx = new ChildData("Styx", 15000);
    ChildData reoSpeedwagon = new ChildData("REO Speedwagon", 20000);
    ChildData boston = new ChildData("Boston", 6200);

    return Arrays.asList(queen, styx, reoSpeedwagon, boston);
  }
}

