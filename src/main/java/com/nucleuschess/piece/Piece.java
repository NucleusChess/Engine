package com.nucleuschess.piece;/*
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

import com.nucleuschess.Color;
import com.nucleuschess.board.Position;
import com.nucleuschess.move.MoveChecker;

public abstract class Piece implements MoveChecker {

    private final Color color;
    private Position position;
    private boolean hasMoved = false;

    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    public Piece(Color color) {
        this.color = color;
    }

    public final String getName() {
        return getClass().getSimpleName();
    }

    public abstract String getCode();

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        hasMoved = true;
    }

    public boolean hasMoved() {
        return hasMoved;
    }
}
