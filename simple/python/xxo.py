# -*- coding: utf-8 -*-
FIELD = [   ["7", "8", "9"],
            ["4", "5", "6"],
            ["1", "2", "3"]
        ]


def pretty_print_field():
    global FIELD
    for row in FIELD:
        print("{}\t{}\t{}".format(row[0],row[1],row[2]))


def is_winner():
    global FIELD
    if FIELD[0][0] == FIELD[1][1] == FIELD[2][2]:
        return True
    if FIELD[0][2] == FIELD[1][1] == FIELD[2][0]:
        return True
    for i in range(3):
        if FIELD[i][0] == FIELD[i][1] == FIELD[i][2]:
            return True
        if FIELD[0][i] == FIELD[1][i] == FIELD[2][i]:
            return True
    return False


def get_position(player):
    wrkong_input = True
    while wrkong_input:
        print("Player '{}' select a position:\n".format(player))
        position = input()
        try:
            if 1 <= int(position) <= 9:
                return str(position)
        except:
            pass
        print("Wrong input. Please choose a number between 1 and 9!")
        pretty_print_field()


def set_on_field(position, player):
    global FIELD
    for i in range(len(FIELD)):
        for j in range(len(FIELD[i])):
            if position == FIELD[i][j]:
                FIELD[i][j] = player
                return True
    return False


if __name__ == "__main__":
    players = ["O","X"]
    player = ""
    play = 1

    while play:
        player = players[play%2]
        pretty_print_field()
        while True:
            position = get_position(player)
            if set_on_field(position, player):
                break
            else:
                print("The position is already set, please choose another one!")
                pretty_print_field()

        play = 0 if is_winner() else play+1

    pretty_print_field()
    print("Congrats player '{}' is the winner!".format(player))
