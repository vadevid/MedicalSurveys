import {Card} from "./card";

export class CardTile implements Card{
  id: number;
  doctor: string;
  name: string;
  type: string;
  cols: number;
  rows: number;
}
