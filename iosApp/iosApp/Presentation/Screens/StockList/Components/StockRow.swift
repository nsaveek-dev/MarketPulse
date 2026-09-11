import SwiftUI

private let priceColumnWidth: CGFloat = 80
private let changeColumnWidth: CGFloat = 96

struct StockListHeader: View {
    var body: some View {
        HStack(spacing: 12) {
            headerLabel("SYMBOL")
                .frame(maxWidth: .infinity, alignment: .leading)
            headerLabel("PRICE")
                .frame(width: priceColumnWidth, alignment: .trailing)
            headerLabel("CHANGE")
                .frame(width: changeColumnWidth, alignment: .trailing)
        }
        .padding(.horizontal, 32)
        .padding(.vertical, 12)
    }

    private func headerLabel(_ text: String) -> some View {
        Text(text)
            .font(.caption)
            .fontWeight(.semibold)
            .foregroundColor(.secondary)
            .lineLimit(1)
    }
}

struct StockRow: View {
    let symbol: String
    let price: String
    let change: String
    let changePercent: String
    var changeColor: Color = .primary

    var body: some View {
        HStack(spacing: 12) {
            SymbolAvatar(symbol: symbol)
            Text(symbol)
                .font(.headline)
                .fontWeight(.bold)
                .lineLimit(1)
                .truncationMode(.tail)
                .frame(maxWidth: .infinity, alignment: .leading)
            Text(price)
                .font(.headline)
                .fontWeight(.semibold)
                .lineLimit(1)
                .frame(width: priceColumnWidth, alignment: .trailing)
            ChangePill(change: change, changePercent: changePercent, changeColor: changeColor)
                .frame(width: changeColumnWidth)
        }
        .padding(.horizontal, 16)
        .padding(.vertical, 14)
        .background(
            RoundedRectangle(cornerRadius: 16)
                .fill(Color(.secondarySystemGroupedBackground))
                .shadow(color: Color.black.opacity(0.08), radius: 3, x: 0, y: 1)
        )
        .padding(.horizontal, 16)
        .padding(.vertical, 6)
    }
}

private struct SymbolAvatar: View {
    let symbol: String

    var body: some View {
        Text(symbol.prefix(1).uppercased())
            .font(.headline)
            .fontWeight(.bold)
            .foregroundColor(.accentColor)
            .frame(width: 40, height: 40)
            .background(Color.accentColor.opacity(0.15))
            .clipShape(Circle())
    }
}

private struct ChangePill: View {
    let change: String
    let changePercent: String
    let changeColor: Color

    var body: some View {
        let trend: String = changePercent.hasPrefix("+") ? "▲ " : (changePercent.hasPrefix("-") ? "▼ " : "")
        VStack(alignment: .trailing, spacing: 2) {
            Text("\(trend)\(changePercent)")
                .font(.subheadline)
                .fontWeight(.bold)
                .foregroundColor(changeColor)
                .lineLimit(1)
            Text(change)
                .font(.caption2)
                .foregroundColor(changeColor.opacity(0.85))
                .lineLimit(1)
        }
        .frame(maxWidth: .infinity, minHeight: 48, alignment: .trailing)
        .padding(.horizontal, 10)
        .padding(.vertical, 6)
        .background(
            RoundedRectangle(cornerRadius: 10)
                .fill(changeColor.opacity(0.12))
        )
    }
}

func changeColor(_ change: Double) -> Color {
    if change > 0 {
        return Color(red: 0x1B / 255, green: 0x87 / 255, blue: 0x3F / 255)
    }
    if change < 0 {
        return Color(red: 0xC6 / 255, green: 0x28 / 255, blue: 0x28 / 255)
    }
    return .primary
}
