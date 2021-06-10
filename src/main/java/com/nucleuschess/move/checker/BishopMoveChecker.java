package com.nucleuschess.move.checker;

import com.nucleuschess.board.Board;
import com.nucleuschess.move.AbstractMoveChecker;
import com.nucleuschess.move.Move;
import com.nucleuschess.piece.Bishop;

/*
  Copyright (C) 2021, NucleusChess.
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
public final class BishopMoveChecker extends AbstractMoveChecker<Bishop> {

    public BishopMoveChecker(Board board) {
        super(board);
    }

    @Override
    public boolean check(Bishop piece, Move move) {
        // Bishops can only move diagonal
        if (!isDiagonal(move)) return false;
        if (!board.isEmpty(move.getTo())) return false;

        return !board.hasObstructionDiagonally(move.getFrom(), move.getTo());
    }
}
