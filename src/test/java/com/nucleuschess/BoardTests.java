package com.nucleuschess;

import com.nucleuschess.board.Board;
import com.nucleuschess.board.Position;
import com.nucleuschess.piece.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

/*
  Copyright (C) 2020-2021, Wouter Kistemaker.
  This program is free software: you can redistribute it and/or modify
  it under the terms of the GNU Affero General Public License as published
  by the Free Software Foundation, either version 3 of the License, or
  (at your option) any later version.
  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU Affero General Public License for more details.
  You should have received a copy of the GNU Affero General Public License
  along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/
public class BoardTests {

    private static Board board;
    private static Random random;

    @BeforeAll
    public static void createBoard() {
        board = new Board();
    }

    @BeforeAll
    public static void initializeRandom() {
        random = new Random();
    }

    @Test
    public void checkPieces() {
        final int[] ranks = {1, 2, 7, 8};
        final int rank = ranks[random.nextInt(ranks.length)];

        final int fileNumber = random.nextInt(8) + 1; // since the random returns between 0 and 7 but we want 1 and 8
        final Position position = board.getPosition(fileNumber, rank);
        final Piece piece = position.getPiece();

        Assertions.assertNotNull(piece);
        Assertions.assertEquals("K", board.getPosition(5, 1).getPiece().getCode());
    }

    @Test
    public void checkBoard() {
        Assertions.assertNotNull(board);
        final String[] expected = {
                "RNBQKBNR",
                "PPPPPPPP",
                "OOOOOOOO",
                "OOOOOOOO",
                "OOOOOOOO",
                "OOOOOOOO",
                "PPPPPPPP",
                "RNBQKBNR"
        };
        StringBuilder builder;
        for (int i = 1; i < 9; i++) {
            builder = new StringBuilder();
            for (int j = 1; j < 9; j++) {
                final Position position = board.getPosition(j, i);
                final String code = position.isEmpty() ? "O" : position.getPiece().getCode();
                builder.append(code);
            }
            Assertions.assertEquals(expected[i - 1], builder.toString());
        }
    }
}

// rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w - - 0 1
